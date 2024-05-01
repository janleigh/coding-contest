package org.contest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class IsPrimeNumberBenchmark {
	private Random random = new Random();

	@Benchmark()
    public void benchmark(Blackhole bh) {
		for (int i = 0; i < 1000; i++) {
			long randomNumber = (long) random.nextInt(Integer.MAX_VALUE) + random.nextInt(Integer.MAX_VALUE) * (long) Integer.MAX_VALUE;
			randomNumber = Math.abs(randomNumber % 2_000_000_000) + 2;
			bh.consume(IsPrimeNumber.isPrime((int) randomNumber));
		}
    }

	@Benchmark()
	public void benchmarkFastest(Blackhole bh) {
		for (int i = 0; i < 1000; i++) {
			long randomNumber = (long) random.nextInt(Integer.MAX_VALUE) + random.nextInt(Integer.MAX_VALUE) * (long) Integer.MAX_VALUE;
			randomNumber = Math.abs(randomNumber % 2_000_000_000) + 2;
			boolean isPrime = a(randomNumber);
			bh.consume(isPrime);
		}
	}

	private boolean a(long x) {
		return x > 1 && java.math.BigInteger.valueOf(x).isProbablePrime(20);
	}
}
