package org.contest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

import java.util.concurrent.TimeUnit;

class VowelCountTest {
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testBasic() {
		assertEquals(5, VowelCount.getCount("abracadabra"));
		assertEquals(3, VowelCount.getCount("imissher"));
		assertEquals(4, VowelCount.getCount("vowel count"));
		assertEquals(7, VowelCount.getCount("when i was a young boy"));
		assertEquals(0, VowelCount.getCount("bcdfghjklmnpqrstvwxyz"));
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = SEPARATE_THREAD)
	void testLong() {
		assertEquals(11, VowelCount.getCount("antidisestablishmentarianism"));
		assertEquals(16, VowelCount.getCount("supercalifragilisticexpialidocious"));
		assertEquals(16, VowelCount.getCount("hippopoto monstro sesquippedalio phobia"));
		assertEquals(20, VowelCount.getCount("pneumonoultramicroscopicsilicovolcanoconiosis"));
		assertEquals(39, VowelCount.getCount(
						"each\r\n" + //
						"word\r\n" + //
						"form\r\n" + //
						"about\r\n" + //
						"while\r\n" + //
						"under\r\n" + //
						"most\r\n" + //
						"feel\r\n" + //
						"go\r\n" + //
						"move\r\n" + //
						"up\r\n" + //
						"interest\r\n" + //
						"state\r\n" + //
						"many\r\n" + //
						"find\r\n" + //
						"well\r\n" + //
						"last\r\n" + //
						"still\r\n" + //
						"man\r\n" + //
						"set\r\n" + //
						"course\r\n" + //
						"few\r\n" + //
						"become\r\n" + //
						"the\r\n" + //
						"word\r\n" + //
						""
		));	
	}
}
