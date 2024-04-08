package org.contest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class CollatzSequenceBenchmark {
	@Benchmark()
	public void benchmark(Blackhole bh) {
		for (int i = 0; i < 10000; i++) {
			long uint64 = (long) Math.floor(Math.random() * (1000000000L - 1000000L) + 1000000L);
			bh.consume(CollatzSequence.collatzSequenceLength(uint64));
		}
	}

	@Benchmark()
	public void benchmarkFastest(Blackhole bh) {
		for (int i = 0; i < 10000; i++) {
			long uint64 = (long) Math.floor(Math.random() * (1000000000L - 1000000L) + 1000000L);
			bh.consume(a(uint64));
		}
	}

	private long a(long x) {
		long b = 2;
		while ((x = x % 2 == 0 ? x / 2 : x * 3 + 1) != 1) {
			b++;
		}
		
		return b;
	}
}
