package org.bobo.spring;

import lombok.Data;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@Data
public class ShutdownHandler implements SignalHandler {
    /**
     * 处理信号
     *
     * @param signal 信号
     */
    public void handle(Signal signal) {
    }

    private void registerShutdownHook()
    {
        Thread t = new Thread(new ShutdownHook(), "ShutdownHook-Thread");
        Runtime.getRuntime().addShutdownHook(t);
    }
}