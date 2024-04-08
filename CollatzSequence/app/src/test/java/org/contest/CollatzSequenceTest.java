package org.contest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

import java.util.concurrent.TimeUnit;

class CollatzSequenceTest {
	@Test 
	void testBasic() {
		assertEquals(0, CollatzSequence.collatzSequenceLength(0));
		assertEquals(1, CollatzSequence.collatzSequenceLength(1));
		assertEquals(6, CollatzSequence.collatzSequenceLength(5));
		assertEquals(10, CollatzSequence.collatzSequenceLength(13));
	}

	@Test
	void testNonPositive() {
		assertEquals(0, CollatzSequence.collatzSequenceLength(-1));
		assertEquals(0, CollatzSequence.collatzSequenceLength(-5));
		assertEquals(0, CollatzSequence.collatzSequenceLength(-13));
		assertEquals(0, CollatzSequence.collatzSequenceLength(-69));
		assertEquals(0, CollatzSequence.collatzSequenceLength(-420));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testCaseLargeNumbers() throws InterruptedException {
		assertEquals(35, CollatzSequence.collatzSequenceLength(230));
		assertEquals(112, CollatzSequence.collatzSequenceLength(1000));
		assertEquals(259, CollatzSequence.collatzSequenceLength(999999));
		assertEquals(164, CollatzSequence.collatzSequenceLength(56373890));
		assertEquals(181, CollatzSequence.collatzSequenceLength(987654321));
		assertEquals(276, CollatzSequence.collatzSequenceLength(1000000000000000L));
		assertEquals(451, CollatzSequence.collatzSequenceLength(Integer.MAX_VALUE - 1));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testRandom() {
		for (int i = 0; i < 10000; i++) {
			long uint64 = (long) Math.floor(Math.random() * (1000000000L - 1000000L) + 1000000L);
			assertEquals(a(uint64), CollatzSequence.collatzSequenceLength(uint64));
		}
	}

	private long a(long b) {
		return b == 1 ? 1 : 1 + (b % 2 == 0 ? a(b / 2) : a(b * 3 + 1));
	}
}
