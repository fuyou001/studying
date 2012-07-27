package com.fuyou.thrift.jnb;


import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-25
 * Time: 下午1:32
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    public static final int PORT = 9000;

    public static void main(String[] args) throws Exception {
        //TBinaryProtocolServer();
        TCompactServer();

    }

    public static void TCompactServer() throws TTransportException {

        TNonblockingServerSocket socket = new TNonblockingServerSocket(PORT);
        CourseService.Processor processor = new CourseService.Processor(new Handler());
        THsHaServer.Args arg = new THsHaServer.Args(socket);
        // 高效率的、密集的二进制编码格式进行数据传输
        // 使用非阻塞方式，按块的大小进行传输，类似于 Java 中的 NIO
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        System.out.println("#服务启动-使用:非阻塞&高效二进制编码");
        TServer server = new THsHaServer(arg);
        //TServer server = new TNonblockingServer(arg);
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

    public static void TBinaryProtocolServer() throws TTransportException {

        TServerSocket serverTransport = new TServerSocket(PORT);
        CourseService.Processor processor = new CourseService.Processor(new Handler());
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

        System.out.println("Starting server on port " + PORT);
        server.serve();
    }

    private static class Handler implements CourseService.Iface {
        @Override
        public List<String> getCourseInventory() throws TException {
            System.out.println("I am here getCourseInventory");
            return new ArrayList<String>();
        }

        @Override
        public Course getCourse(String courseNumber) throws CourseNotFound, TException {
            System.out.println("I am here getCourse");
//            if (true) {
//                throw new CourseNotFound().setMessage("getCourse..");
//            }
            return new Course();
        }

        @Override
        public void addCourse(Course course) throws UnacceptableCourse, TException {
//            if (true) {
//                throw new UnacceptableCourse();
//            }
            System.out.println("I am here addCourse");
        }

        @Override
        public void deleteCourse(String courseNumber) throws CourseNotFound, TException {
            System.out.println("I am here deleteCourse");
        }
    }
}
