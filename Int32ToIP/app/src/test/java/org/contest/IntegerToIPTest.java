package org.contest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class IntegerToIPTest {
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testBasic() {
		assertEquals("0.0.0.0", IntegerToIP.intToIP(0));
		assertEquals("0.0.0.32", IntegerToIP.intToIP(32));
		assertEquals("128.32.10.1", IntegerToIP.intToIP(2149583361L));
		assertEquals("166.207.75.65", IntegerToIP.intToIP(2798603073L));
		assertEquals("255.255.255.255", IntegerToIP.intToIP(Long.MAX_VALUE));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testRandom() {
		for (int i = 0; i < 500; i++) {
			int uint32 = randInt32();
			assertEquals(a(uint32), IntegerToIP.intToIP(uint32));
		}
	}

	private static int randInt32() {
		Random random = new Random();
		StringBuilder bits = new StringBuilder(32);

		for (int i = 0; i < 32; i++) {
			bits.append(random.nextInt(2));
		}

		return Integer.parseUnsignedInt(bits.toString(), 2);
	}

	private static String a(long x) {
		StringBuilder b = new StringBuilder();
		int i = 0;
		
		while (i < 4) {
			int c = (int) x & 0xFF;
			b.insert(0, c);
			if (i < 3) {
				b.insert(0, ".");
			}
			
			x >>= 8;
			i++;
		}

		return b.toString();
	}
}
