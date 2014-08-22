package name.mitterdorfer.sharing.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 15)
@Fork(5)
@Threads(4)
public class FalseSharingMicroBenchmark {

    @State(Scope.Benchmark)
    public static class FalselySharedState {
        public long write;
        public long read;
    }

    @Group("false_sharing")
    @GroupThreads(1)
    @Benchmark
    public void produce(FalselySharedState s) {
        s.write++;
    }

    @Group("false_sharing")
    @GroupThreads(3)
    @Benchmark
    public long consume(FalselySharedState s) {
        return s.read;
    }
}
