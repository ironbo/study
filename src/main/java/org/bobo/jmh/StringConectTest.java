package org.bobo.jmh;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author huangjiangbo
 * @date 2021-05-03 17:02
 * @description JMH学习
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringConectTest {

  @Param(value = {"10", "50", "100"})
  private int length;

  /**
   * blackhole 避免jvm编译优化中的dead code·消除
   */
  @Benchmark
  public void testStringBuild(Blackhole blackhole) {
    StringBuilder a = new StringBuilder();
    for (int j = 0; j < length; j++) {
      a.append(j);
    }
  }

  @Benchmark
  public void testStringAdd(Blackhole blackhole) {
    String a = "";
    for (int j = 0; j < length; j++) {
      a += j;
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options chainedOptionsBuilder = new OptionsBuilder()
        .include(StringConectTest.class.getSimpleName())
        .result("result.json")
        .resultFormat(ResultFormatType.JSON).build();
    new Runner(chainedOptionsBuilder).run();
  }
}
