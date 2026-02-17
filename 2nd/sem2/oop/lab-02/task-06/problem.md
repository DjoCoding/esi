## Task: Password Validation

**Description:**  
Read a password and print `ACCEPTED` or `REJECTED` based on the following rules. All rules **must be satisfied**.

---

### Rules

1. Length is between **8 and 16** (inclusive)
2. Contains **at least one uppercase letter** (`A–Z`)
3. Contains **at least one lowercase letter** (`a–z`)
4. Contains **at least one digit** (`0–9`)
5. Contains **at least one special character** from: `@ # $ % !`
6. Must **not contain a space**
7. Must **not contain the same character repeated 3 times in a row**  
   _(e.g., `aaA1@bbb` is rejected because of `bbb`)_

---

### Input

- One line: password

### Output

- `ACCEPTED` if the password is valid
- Otherwise, `REJECTED: <reason>` (print the **first rule that fails**)
