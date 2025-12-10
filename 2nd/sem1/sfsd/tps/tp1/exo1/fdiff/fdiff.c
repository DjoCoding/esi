#include <fdiff.h>
#include <fcontent.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>


size_t fdiff(const char *f1, const char *f2) {
    char *f1_content = fcontent(f1);
    char *f2_content = fcontent(f2);

    size_t f1_content_len = strlen(f1_content);
    size_t f2_content_len = strlen(f2_content);
    size_t min_len = f1_content_len < f2_content_len ? f1_content_len : f2_content_len;

    size_t line = 1;

    size_t i = 0;
    while(i < min_len) {
        if(f1_content[i] != f2_content[i]) goto getout;
        if(f1_content[i] == '\n') line += 1;
        i += 1; 
    }

    if(f1_content_len == f2_content_len) goto getout_no_diff;

    char *bigger_content = f1_content_len < f2_content_len ? f2_content : f1_content;
    if(bigger_content[i] == '\n') line += 1;

getout:
    free(f1_content);
    free(f2_content);
    return line;

getout_no_diff:
    free(f1_content);
    free(f2_content);
    return FDIFF_NO_LINE;
}
