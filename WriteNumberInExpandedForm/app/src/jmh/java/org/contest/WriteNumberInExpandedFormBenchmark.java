package org.contest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class WriteNumberInExpandedFormBenchmark {
	@Benchmark()
	public void benchmark(Blackhole bh) {
		for (int i = 0; i < 1000; i++) {
			int uint32 = randInt32();
			bh.consume(WriteNumberInExpandedForm.expandedForm(uint32));
		}
	}

	@Benchmark()
	public void benchmarkFastest(Blackhole bh) {
		for (int i = 0; i < 1000; i++) {
			int uint32 = randInt32();
			bh.consume(a(uint32));
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

	private String a(int n) {
		String x = "";
		int i = 10;
		
        while (i < n) {
            int r = n % i;
            x = (r > 0)
				? " + " + r + x
				: x;

            n -= r;
			i *= 10;
        }
        x = n + x;
        
        return x;
	}
}
