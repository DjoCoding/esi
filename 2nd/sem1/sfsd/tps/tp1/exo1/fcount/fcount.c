#include <fcount.h>
#include <fcontent.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define __BUFFER_MAX_CAP__ 1024

size_t fcount(const char *filename, char *word) {
    if(word == NULL) {
        fprintf(stderr, "fcount failed: given word should not equal NULL\n");
        exit(EXIT_FAILURE);
    }

    char *content = fcontent(filename);
    
    size_t content_len = strlen(content);
    size_t word_len = strlen(word);

    char buffer[__BUFFER_MAX_CAP__] = {0};
    size_t i = 0;
    size_t count = 0;

    while(i <= content_len - word_len) {
        memset(buffer, 0, __BUFFER_MAX_CAP__);

        memcpy(buffer, &content[i], word_len);
        if(strcmp(buffer, word) == 0) {
            count += 1;
            i += word_len;
            continue;
        }

        i += 1;
    }

    free(content);
    return count;
}
