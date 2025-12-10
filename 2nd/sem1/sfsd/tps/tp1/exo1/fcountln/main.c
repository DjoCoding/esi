#include <fcountln.h>

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

const char *FILENAME   = "./test.txt";

int main(void) {
    size_t count = fcountln(FILENAME);
    printf("count: %zu\n", count);
    return 0;
}