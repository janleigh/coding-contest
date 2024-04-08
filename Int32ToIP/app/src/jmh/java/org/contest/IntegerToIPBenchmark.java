package org.contest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class IntegerToIPBenchmark {
	@Benchmark()
	public void benchmark(Blackhole bh) {
		for (int i = 0; i < 500; i++) {
			int uint32 = randInt32();
			bh.consume(IntegerToIP.intToIP(uint32));
		}
	}

	@Benchmark()
	public void benchmarkFastest(Blackhole bh) {
		for (int i = 0; i < 500; i++) {
			int uint32 = randInt32();
			bh.consume(solution(uint32));
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

	private static String solution(int int32) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			int byteValue = int32 & 0xFF;
			result.insert(0, byteValue);
			if (i < 3) {
				result.insert(0, ".");
			}
			int32 >>= 8;
		}

		return result.toString();
	}
}
