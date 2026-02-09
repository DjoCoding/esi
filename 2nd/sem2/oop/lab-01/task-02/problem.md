# Task 2: Integer Digit Logic: “Code Validity”

## Description

Using command-line arguments, read a 4-digit positive integer `n`. Determine if it is **valid** using the following rule:

- Let the digits be `a b c d` (thousands to units).
- The number is **valid** if `(a + d) == (b + c)` **and** `n` is even.

## Input

One integer `n` (1000–9999).

## Output

Print `VALID` or `INVALID`.

## Constraints

`n` must be a 4-digit integer. You may assume it is, or reject otherwise.

---

## Example Usage

```bash
java Main 2426
```
