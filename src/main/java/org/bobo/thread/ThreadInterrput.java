package org.bobo.thread;

import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huangjiangbo
 * @date 2021-08-17 19:19
 * @description time_wait和wait会对中断做出响应 这也可以从实际编码中看得出来，只有sleep和wait需要显示的抛出{@link
 * InterruptedException}异常 <br/> new和terminal是一定不会对中断做出相应。 <br/> runnable和blocked，需要在线程的执行方法中显示的查看并处理中断标志才能获得对中断处理的能力，这样做的
 * 好处在于可以把对中断的处理操作下放到用户端，增加代码的灵活性，<br/>
 */
@Log4j2
public class ThreadInterrput {

  Thread thread1 = null;

  @Before
  public void before() {
    thread1 = new Thread(() -> log.info("1号线程执行中..."));
    thread1.setName("thread1");
  }

  @Test
  public void threadRunning() {
    thread1.start();
    thread1.interrupt();
    log.info("{}状态：{}", thread1.getName(), thread1.getState());
  }

  @Test
  public void threadBlocking() throws InterruptedException {
    Thread thread = new Thread(() -> {
      synchronized (this) {
        log.info("{}获取锁", Thread.currentThread().getName());
        log.info("{}状态：{}", Thread.currentThread().getName(), Thread.currentThread().getState());
      }
    });
    thread.start();
    synchronized (this) {
      thread.interrupt();
    }
    Thread.sleep(2000);
  }

  @Test
  public void threadTimeWaiting() throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        log.info("{}中断状态：{}", Thread.currentThread().getName(),
            Thread.currentThread().isInterrupted());
        Thread.sleep(2000L);
      } catch (InterruptedException e) {
        log.error("中断响应，{}中断状态：{}", Thread.currentThread().getName(),
            Thread.currentThread().isInterrupted());
      }
    });
    thread.start();
    thread.interrupt();
    Thread.sleep(100L);
    log.info("{}状态：{}", thread.getName(), thread.getState());
  }
}
