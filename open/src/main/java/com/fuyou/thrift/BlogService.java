package com.fuyou.thrift;

import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-24
 * Time: ÏÂÎç2:52
 * To change this template use File | Settings | File Templates.
 */
public class BlogService  implements ThriftCase.Iface{
    @Override
    public int testCase1(int num1, int num2, String num3) throws TException {
        return num1+num2;
    }

    @Override
    public List<String> testCase2(Map<String, String> num1) throws TException {
        List<String> list = new ArrayList<String>();
        list.add("Hello Thrift");
        return list;
    }

    @Override
    public void testCase3() throws TException {
        System.out.println("testCase3");
    }

    @Override
    public void testCase4(List<Blog> blog) throws TException {
        if(blog!=null){
            for(Blog each:blog){
                System.out.println(each);
            }
        }
    }
}
