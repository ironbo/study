package org.bobo.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import lombok.extern.log4j.Log4j2;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 我也不记得这里是测啥的
 */
@Log4j2
public class SocketTest {


    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8088);
        ServerSocket serverSocket1 = new ServerSocket(8082);
        InputStream in = new Socket("localhost",8088).getInputStream();
        InputStream in1 = new Socket("localhost",8082).getInputStream();
        exe.execute(new IOJob(System.in));
        exe.execute(new IOJob(in1));
        TimeUnit.SECONDS.sleep(2);
        exe.shutdownNow();
        TimeUnit.SECONDS.sleep(2);
        log.info("close socket");
//        in.close();
        System.in.close();
        TimeUnit.SECONDS.sleep(2);
        log.info("close sys");
        in1.close();

    }
}
@Log4j2
class IOJob implements Runnable {
    private InputStream in;

    public IOJob(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            log.info("reading");
            in.read();
            log.info("11");
        }catch (Exception e){
            log.info(e);
            if(Thread.interrupted()){
                log.info("interrupted");
            }else{
                log.info("no interrupted");
            }
        }
    }
}