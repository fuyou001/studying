package com.fuyou.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-25
 * Time: ÉÏÎç11:34
 * To change this template use File | Settings | File Templates.
 */
public class BeanExampleClientExample {
    private static final int PORT = 7911;

    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", PORT);
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            ServiceExample.Client client = new ServiceExample.Client(protocol);
            transport.open();
            BeanExample bean = client.getBean(2, "yubaofu...hello thrfit");
            System.out.println("bean:"+bean);
            System.out.println(bean.getStringObject());

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

           // System.out.println(bean.getStringObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
