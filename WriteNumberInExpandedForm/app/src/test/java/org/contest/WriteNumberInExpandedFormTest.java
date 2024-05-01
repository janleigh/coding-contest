package org.contest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class WriteNumberInExpandedFormTest {
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testBasic() {
		assertEquals("10 + 2", WriteNumberInExpandedForm.expandedForm(12));
		assertEquals("60 + 9", WriteNumberInExpandedForm.expandedForm(69));
		assertEquals("4000 + 200 + 60 + 5", WriteNumberInExpandedForm.expandedForm(4265));
		assertEquals("70000 + 3000 + 400 + 50 + 6", WriteNumberInExpandedForm.expandedForm(73456));
		assertEquals("1000000 + 200000 + 30000 + 4000 + 500 + 60 + 7", WriteNumberInExpandedForm.expandedForm(1234567));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testRandom() {
		for (int i = 0; i < 1000; i++) {
			int uint32 = new Random().nextInt(1000000);
			assertEquals(a(uint32), WriteNumberInExpandedForm.expandedForm(uint32));
		}
	}

	private static String a(int n) {
		String s = "";
		int i = 0;

		while (n > 0){
			s = n % 10 == 0 
				? s
				: n % 10 * (int) Math.pow(10, i) + " + " + s; 
			
			n /= 10;
			i++;
		}

		return s.substring(0, s.length() - 3);
	}
}
