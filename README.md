# Block Cipher Encryption and Decryption (Java)
<img src="https://i.pinimg.com/originals/b3/9d/00/b39d004739a48bcc60f771089bb7ecd3.gif"></img>
## Overview

This project demonstrates a **basic block cipher encryption and decryption system** implemented in **Java**.
The program converts plaintext into binary, splits it into blocks, applies bitwise operations using a secret key,
and successfully decrypts the data back into the original message.

**Disclaimer:** This implementation is **strictly for educational and academic purposes**.
It is **not secure** and must **not** be used for real-world cryptographic applications.

---

## What is a Block Cipher?

A **block cipher** is a symmetric-key cryptographic technique that:

* Encrypts data in **fixed-size blocks**
* Uses the **same secret key** for encryption and decryption
* Applies **bitwise and logical operations** to transform data
* Ensures reversibility through mathematical properties (e.g., XOR)

Most block ciphers are based on structured designs such as **Feistel networks** or **Substitution–Permutation Networks**.

Examples of real-world block ciphers include **DES** and **AES**.

---

## Conceptual Working of a Block Cipher

The general working flow of a block cipher is as follows:

1. Convert plaintext into binary representation
2. Split the binary data into two equal halves:

   * Left Block (L)
   * Right Block (R)
3. Generate a secret key of equal length
4. Apply a round function on one half using the key
5. Combine both halves using XOR
6. Swap the halves (Feistel-style structure)
7. Combine the blocks to form ciphertext
8. Reverse the same steps to decrypt the ciphertext

This project implements a **single-round Feistel-like block cipher**.

---

## Code Explanation

### 1. Core Variables

* **Left Block (L):** First half of binary data
* **Right Block (R):** Second half of binary data
* **Key (K):** Binary key used for encryption and decryption
* **Padding Flag:** Ensures correct block size during processing

---

### 2. String to Binary Conversion

The plaintext string is converted into **8-bit ASCII binary**.

Purpose:

* Block ciphers operate on bits, not characters
* Ensures consistent block size
* Maintains reversibility

---

### 3. Block Splitting

The binary string is divided into two equal halves:

```
L = first half
R = second half
```

This mirrors the structure used in standard block ciphers.

---

### 4. Key Generation

A binary key is generated using XOR with a randomly generated bit.

Key properties:

* Same length as block size
* Symmetric (used in both encryption and decryption)
* Simplified for educational clarity

---

### 5. Round Function

The round function is defined as:

```
F(L, R, K) = L XOR (R AND K)
```

Operations used:

* AND (∧)
* XOR (⊕)

This function introduces basic confusion and diffusion concepts.

---

### 6. Encryption Process

Encryption follows these steps:

1. Right block becomes the new left block
2. Round function output is XORed with the left block
3. Blocks are concatenated to form ciphertext

Due to the Feistel structure, encryption does not require a separate inverse function.

---

### 7. Decryption Process

Decryption reverses the encryption steps:

1. Split ciphertext into two halves
2. Apply the same round function
3. Use XOR to recover original data
4. Combine blocks to obtain plaintext binary

This works because XOR is reversible.

---

### 8. Binary to String Conversion

After decryption, the binary data is:

* Grouped into 8-bit chunks
* Converted back to ASCII characters
* Reconstructed into the original string

---

## Key Features

* Bit-level encryption and decryption
* Feistel-style block cipher structure
* Symmetric key usage
* Demonstrates encryption reversibility
* Suitable for cryptography theory understanding

---

## Security Notice

This cipher is **not secure** for real-world use due to:

* Only one encryption round
* Weak key generation
* No cryptographic randomness
* No padding standard
* No fixed block size enforcement

It is intentionally simplified for learning purposes.

---

## Possible Enhancements

* Multiple encryption rounds
* Proper key scheduling
* Stronger nonlinear round functions
* Padding schemes
* Fixed block sizes
* Comparison with DES/AES

---

## Conclusion

This project provides a clear and practical demonstration of **block cipher fundamentals** using Java.
It is designed to help students understand:

* Binary data processing
* Feistel network structure
* Bitwise encryption operations
* Symmetric encryption concepts

The implementation is ideal for **academic study, lab work, and cryptography theory courses**.

---

## Author

Ali Akbar Khan
B.Tech – 6th Semester
Information Systems Security (ISS)
