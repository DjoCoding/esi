## Task 3: Caesar Cipher Encryption

**Description:**  
Read a message and an integer shift `k`. Encrypt **letters only** using a Caesar cipher.

**Rules:**

- `A–Z` stays uppercase
- `a–z` stays lowercase
- Wrap around the alphabet (e.g., `z` with shift 2 → `b`)
- Non-letter characters remain unchanged

**Example:**

- Input: `abc`, `k = 1`
- Output: `bcd`

**Input:**

- One line (message)
- One integer `k`

**Output:**

- Encrypted line

**Constraints:**

- Normalize `k` to the range `[0, 25]`