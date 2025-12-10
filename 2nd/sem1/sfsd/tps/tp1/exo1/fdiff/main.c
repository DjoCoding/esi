#include <fdiff.h>

#include <stdio.h>
#include <stdlib.h>

const char *FILENAME_1 = "./test1.txt";
const char *FILENAME_2 = "./test2.txt";

int main(void) {
    size_t line = fdiff(FILENAME_1, FILENAME_2);
    if(line == FDIFF_NO_LINE) printf("no difference\n");
    else printf("difference -> line: %zu\n", line);
    return 0;
}