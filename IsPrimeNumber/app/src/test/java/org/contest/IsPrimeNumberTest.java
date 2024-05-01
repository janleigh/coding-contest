package org.contest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class IsPrimeNumberTest {
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testBasic() {
		assertTrue(IsPrimeNumber.isPrime(2));
		assertTrue(IsPrimeNumber.isPrime(73));
		assertFalse(IsPrimeNumber.isPrime(0));
		assertFalse(IsPrimeNumber.isPrime(1));
		assertFalse(IsPrimeNumber.isPrime(75));
		assertFalse(IsPrimeNumber.isPrime(-1));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testPrime() {
		assertTrue(IsPrimeNumber.isPrime(3));
		assertTrue(IsPrimeNumber.isPrime(5));
		assertTrue(IsPrimeNumber.isPrime(7));
		assertTrue(IsPrimeNumber.isPrime(41));
		assertTrue(IsPrimeNumber.isPrime(5099));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testNotPrime() {
		assertFalse(IsPrimeNumber.isPrime(4));
		assertFalse(IsPrimeNumber.isPrime(6));
		assertFalse(IsPrimeNumber.isPrime(8));
		assertFalse(IsPrimeNumber.isPrime(9));
		assertFalse(IsPrimeNumber.isPrime(45));
		assertFalse(IsPrimeNumber.isPrime(-41));
		assertFalse(IsPrimeNumber.isPrime(-5));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testRandom() {
		Random random = new Random();

		for (int i = 0; i < 1000; i++) {
			long randomNumber = (long) random.nextInt(Integer.MAX_VALUE) + random.nextInt(Integer.MAX_VALUE) * (long) Integer.MAX_VALUE;
			randomNumber = Math.abs(randomNumber % 2_000_000_000) + 2;
			boolean isPrime = a(randomNumber);
			assertEquals(isPrime, IsPrimeNumber.isPrime((int)randomNumber));
		}
	}

	private boolean a(long x) {
		return x > 1 && java.math.BigInteger.valueOf(x).isProbablePrime(20);
	}
}
