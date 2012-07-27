package com.fuyou.thrift;

import com.fuyou.thrift.jnb.CourseService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-24
 * Time: ����2:55
 * To change this template use File | Settings | File Templates.
 */
public class BlogServiceMain {

    public static void main(String[] args) throws Exception {
        TServerSocket serverTransport = new TServerSocket(7911);
        ThriftCase.Processor processor = new ThriftCase.Processor(new BlogService());
        TBinaryProtocol.Factory protFactory = new TBinaryProtocol.Factory(true, true);
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
        System.out.println("Starting server on port 7911 ...");
        server.serve();

        //TCompactServer();
    }
    public static void TCompactServer() throws TTransportException {

        TNonblockingServerSocket socket = new TNonblockingServerSocket(7911);
        ThriftCase.Processor processor = new ThriftCase.Processor(new BlogService());
        THsHaServer.Args arg = new THsHaServer.Args(socket);
        // ��Ч�ʵġ��ܼ��Ķ����Ʊ����ʽ�������ݴ���
        // ʹ�÷�������ʽ������Ĵ�С���д��䣬������ Java �е� NIO
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        System.out.println("#��������-ʹ��:������&��Ч�����Ʊ���");
        //TServer server = new THsHaServer(arg);
        TServer server = new TNonblockingServer(arg);
        server.serve();
//        TNonblockingServerSocket socket = new TNonblockingServerSocket(PORT);
//        CourseService.Processor processor = new CourseService.Processor(new Handler());
//        THsHaServer.Args arg = new THsHaServer.Args(socket);
//        arg.protocolFactory(new TCompactProtocol.Factory());
//        arg.transportFactory(new TFramedTransport.Factory());
//        arg.processorFactory(new TProcessorFactory(processor));
//        TServer server = new THsHaServer(arg);
//        System.out.println("service is listen...");
//        server.serve();

    }


}
