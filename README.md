# Java Encryptor Test


><b>Obligatory assignment info:</b>
>* Brandon Martin
>* CEN 3024C: Software Development 1
>* CRNs 31032 and 31506

For this project, I took inspiration from this video: https://www.youtube.com/watch?v=jVpsLMCIB0Y and did my best to make the vigenere table cipher with java.

---

This is a little bit of code I put together for one of my assignments in college. To use it, run `java Main.java` and follow the steps. The code will then encrypt the string and decrypt the string - it will then print out the `encryption key`, `plaintext string`, `encrypted string`, and finally, `decrypted string`.

<b>Important note:</b> all characters will become uppercase when encrypted.

---

### Example Input/Output:


* <b>Encryption key</b>: The key that's used to "encrypt" the string. Must contain only letters - no spaces, numbers, or special symbols.
* <b>String to encrypt</b>: The string to well... encrypt...


```
[user@hostname]$ java Main.java

Please input encryption key: hellothere
Please input string to encrypt: This is a string to encrypt

Encryption String: hellothere
Plaintext String: This is a string to encrypt
Encrypted String: ALTD BZ R ZXCTBZ XF LRNCMIA
Decrypted String: THIS IS A STRING TO ENCRYPT
```