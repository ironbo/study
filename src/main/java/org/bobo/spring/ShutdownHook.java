package org.bobo.spring;

import java.util.concurrent.TimeUnit;

class ShutdownHook implements Runnable
{
        @Override
        public void run() {
                System.out.println("ShutdownHook execute start...");
                try {
                   TimeUnit.SECONDS.sleep(10);//模拟应用进程退出前的处理操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ShutdownHook execute end...");
                }
}