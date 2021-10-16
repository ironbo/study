package org.bobo.thread;

import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huangjiangbo
 * @date 2021-08-17 19:19
 * @description 主要测试了JAVA线程的不同状态
 * @see Thread.State
 */
@Log4j2
public class ThreadState {

  Thread thread1 = null;
  Thread thread2 = null;

  @Before
  public void before() {
    thread1 = new Thread(() -> log.info("1号线程执行中..."));
    thread1.setName("thread1");

    thread2 = new Thread(() -> log.info("2号线程执行中..."));
    thread1.setName("thread2");
  }

  @Test
  public void threadNew() {
    log.info("{}状态：{}", thread1.getName(), thread1.getState());
  }

  @Test
  public void threadRunning() {
    thread1.start();
    log.info("{}状态：{}", thread1.getName(), thread1.getState());
  }

  @Test
  public void threadTerminate() throws InterruptedException {
    thread1.start();
    Thread.sleep(1000L);
    log.info("{}状态：{}", thread1.getName(), thread1.getState());
  }

  @Test
  public void threadTimeWaiting() throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(2000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    thread.start();
    Thread.sleep(100L);
    log.info("{}状态：{}", thread.getName(), thread.getState());
  }

  @Test
  public void threadWaiting() throws InterruptedException {
    Thread mainThread = Thread.currentThread();
    Thread thread = new Thread(() -> {
      int i = 0;
      while (i < 10000) {
        i++;
      }
      log.info("{}状态：{}", mainThread.getName(), mainThread.getState());
    });
    thread.start();
    thread.join();
    log.info("{}状态：{}", thread.getName(), thread.getState());
    log.info("{}状态：{}", Thread.currentThread().getName(), Thread.currentThread().getState());
  }


  @Test
  public void threadBlocking() throws InterruptedException {
    Thread mainThread = Thread.currentThread();
    Thread thread = new Thread(() -> {
      synchronized (this){
        log.info("{}获取锁",Thread.currentThread().getName());
        // 这里不能延时，主线程执行完之后，子线程会被强制关闭
        log.info("{}状态：{}", Thread.currentThread().getName(), Thread.currentThread().getState());
      }
    });
    thread.start();
    synchronized (this){
      log.info("{}获取锁",mainThread.getName());
      log.info("{}状态：{}", mainThread.getName(), mainThread.getState());
      log.info("{}状态：{}", thread.getName(), thread.getState());
    }
  }
}
