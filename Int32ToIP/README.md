## Integer to IP [HARD]

Take this IPv4 address for example: `166.207.75.65`

This address has 4 octets where each octet is a single byte (or 8 bits).
	1st Octet: `166` has a binary representation of `10100110`
	2nd Octet: `207` has a binary representation of `11001111`
	3rd Octet: `75` has a binary representation of `1001011`
	4th Octet: `65` has a binary representation of `1000001`

In this case, `166.207.75.65` == `10100110.11001111.1001011.1000001`
Since the above IPv4 address has 32 bits, we could present it as an 32-bit integer: `2798603073
`
Write a function that takes an 32-bit integer as an input, $int32$, and returns a string representation of its IPv4 address.

Input:
```java
<IntegerToIP>.intToIP("0")
<IntegerToIP>.intToIP("32")
<IntegerToIP>.intToIP("2798603073")
```

Output:
```java
"0.0.0.0"
"0.0.0.32"
"166.207.75.65"
```
