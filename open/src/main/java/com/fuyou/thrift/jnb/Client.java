package com.fuyou.thrift.jnb;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-25
 * Time: ÏÂÎç1:29
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static final int PORT = 9000;

    public static void main(String[] args) throws TException, CourseNotFound, UnacceptableCourse {
        for (int i = 0; i < 1000; i++) {
            System.out.println("index:" + i);
           // TBinaryProtocolClient();
            TCompactClient();
        }
        TCompactClient();
    }

    public static void TCompactClient() throws TException, CourseNotFound {
        String address = "localhost";
        int clientTimeout = 30000;
        TTransport transport = new TFramedTransport(new TSocket(address, PORT,
                clientTimeout));
        TProtocol protocol = new TCompactProtocol(transport);
        CourseService.Client client = new CourseService.Client(protocol);
        transport.open();
       // client.deleteCourse("sese");
        client.getCourse(100 + "");
        //client.addCourse(new Course());
    }

    public static void TBinaryProtocolClient() throws TException, CourseNotFound {
        TTransport transport = new TSocket("localhost", PORT);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        //TProtocol protocol = new TCompactProtocol(transport);
        CourseService.Client client = new CourseService.Client(protocol);
        transport.open();
        client.deleteCourse("sese");
        //client.getCourse(100 + "");
        //client.addCourse(new Course());
    }

}
