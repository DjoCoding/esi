#include <fcountln.h>
#include <fcontent.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>


size_t fcountln(const char *filename) {
    char *content = fcontent(filename);
    size_t content_len = strlen(content);
    
    if(content_len == 0) {
        free(content);
        return 0;
    }

    size_t count = 0;

    for(size_t i = 0; i < content_len; ++i) {
        if(content[i] == '\n') count += 1;
    }

    count += content[content_len - 1] == '\n' ? 0 : 1;

    free(content);
    return count;
}
