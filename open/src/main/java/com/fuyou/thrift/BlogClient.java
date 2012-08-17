package com.fuyou.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-24
 * Time: ÏÂÎç3:09
 * To change this template use File | Settings | File Templates.
 */
public class BlogClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 7911);
        TProtocol protocol = new TBinaryProtocol(transport);
        ThriftCase.Client client = new ThriftCase.Client(protocol);
        transport.open();
        System.out.println("Client is execute...");
        int t = client.testCase1(1, 30, "se");
        System.out.println("ret:" + t);
        client.testCase3();
        List<Blog> blogList = new ArrayList<Blog>();
        for (int i = 0; i < 10; i++) {
            Blog blog = new Blog();
            blog.setId(String.valueOf(i));
            blog.setTopic("topic:" + i);
            blog.setCreatedTime(new Date().getTime());
            blogList.add(blog);
        }
        client.testCase4(blogList);
        transport.close();
    }

}
