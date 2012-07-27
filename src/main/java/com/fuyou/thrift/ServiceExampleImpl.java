package com.fuyou.thrift;

import org.apache.thrift.TException;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-25
 * Time: ÉÏÎç11:30
 * To change this template use File | Settings | File Templates.
 */
public class ServiceExampleImpl implements ServiceExample.Iface {
    @Override
    public BeanExample getBean(int anArg, String anOther) throws TException {
        return new BeanExample(true, (byte) 2, (short) 3, 4, 5, 6.0, anOther, ByteBuffer.wrap(new byte[]{3, 1, 4}));
    }

    @Override
    public void testCase4(List<Blog> blog) throws TException {
        if (blog != null) {
            for (Blog blog1 : blog) {
                System.out.println(blog1);
            }
        }
    }
}
