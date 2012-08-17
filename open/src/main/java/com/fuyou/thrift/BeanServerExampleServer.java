package com.fuyou.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-25
 * Time: ÉÏÎç11:36
 * To change this template use File | Settings | File Templates.
 */
public class BeanServerExampleServer implements Runnable{

    private static final int PORT = 7911;

    @Override
    public void run() {
        try {
            TServerSocket serverTransport = new TServerSocket(PORT);
            ServiceExample.Processor processor = new ServiceExample.Processor(new ServiceExampleImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting server on port " + PORT);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new BeanServerExampleServer()).run();
    }
}
