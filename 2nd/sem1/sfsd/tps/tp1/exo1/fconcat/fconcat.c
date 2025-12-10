#include <fconcat.h>
#include <fcontent.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>


void fconcat(const char *filename, const char *f1, const char *f2) {
    char *f1_content = fcontent(f1);
    char *f2_content = fcontent(f2);

    FILE *f = fopen(filename, "w");
    if(!f) {
        fprintf(stderr, "fconcat failed: %s\n", strerror(errno));
        exit(EXIT_FAILURE);
    }

    if(fwrite(f1_content, strlen(f1_content), 1, f) != 1) {
        fprintf(stderr, "fconcat failed: %s\n", strerror(errno));
        fclose(f);
        exit(EXIT_FAILURE);
    }

    if(fwrite(f2_content, strlen(f2_content), 1, f) != 1) {
        fprintf(stderr, "fconcat failed: %s\n", strerror(errno));
        fclose(f);
        exit(EXIT_FAILURE);
    }

    fclose(f);

    free(f1_content);
    free(f2_content);
}
