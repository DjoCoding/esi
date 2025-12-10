#include <fconcat.h>

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

const char *FILENAME_1 = "./test1.txt";
const char *FILENAME_2 = "./test2.txt";
const char *FILENAME   = "./a.out";

int main(void) {
    fconcat(FILENAME, FILENAME_1, FILENAME_2);
    return 0;
}