#include <fcount.h>

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

const char *FILENAME = "./test.txt";
char *WORD = "HELLO";

int main(void) {
    size_t count = fcount(FILENAME, WORD);
    printf("count: %zu\n", count);
    return 0;
}