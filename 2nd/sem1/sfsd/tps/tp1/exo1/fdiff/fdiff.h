#ifndef FDIFF_H
#define FDIFF_H

#include <stdio.h>
#include <limits.h>

#define FDIFF_NO_LINE ((size_t)-1)

size_t fdiff(const char *f1, const char *f2);

#endif // FDIFF_H