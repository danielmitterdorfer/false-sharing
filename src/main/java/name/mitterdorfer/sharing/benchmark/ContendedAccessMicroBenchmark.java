package name.mitterdorfer.sharing.benchmark;

import org.openjdk.jmh.annotations.*;
import sun.misc.Contended;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 15)
@Fork(value = 5, jvmArgs = "-XX:-RestrictContended")
@Threads(4)
public class ContendedAccessMicroBenchmark {
    @State(Scope.Benchmark)
    public static class ContendedState {
        @Contended
        public long write;

        public long read;
    }

    @Group("contended")
    @GroupThreads(1)
    @Benchmark
    public void produce(ContendedState s) {
        s.write++;
    }

    @Group("contended")
    @GroupThreads(3)
    @Benchmark
    public long consume(ContendedState s) {
        return s.read;
    }
}
