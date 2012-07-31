package com.fuyou.thrift.jnb;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-31
 * Time: ÏÂÎç5:44
 * To change this template use File | Settings | File Templates.
 */
public class ThriftSerializer {
    public static void main(String[] args) throws TException {
        Person person = new Person();
        person.setEmail("fuyou001@gmail.com");
        person.setFirstName("yubao");
        person.setLastName("fu");
        TProtocolFactory tProtocolFactory = new TBinaryProtocol.Factory();
        TProtocolFactory tCompactFactory = new TCompactProtocol.Factory();
        byte[] bytes = serialize(tProtocolFactory, person);

        System.out.println("TBinaryProtocol size:" + bytes.length);
        Person person1 = deserialize(tProtocolFactory, bytes);
        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println("person equals person1:" + person.equals(person1));

        byte[] tCompactBytes = serialize(tCompactFactory, person);
        Person tcompactPerson = deserialize(tCompactFactory, tCompactBytes);
        System.out.println("TCompactProtocol size :" + tCompactBytes.length);
        System.out.println(person.toString());
        System.out.println(tcompactPerson.toString());
        System.out.println("person equals person1:" + person.equals(tcompactPerson));

    }

    public static byte[] serialize(TProtocolFactory tProtocolFactory, Person person) throws TException {
        TSerializer tSerializer = new TSerializer(tProtocolFactory);
        byte[] bytes = tSerializer.serialize(person);
        return bytes;
    }

    public static Person deserialize(TProtocolFactory tProtocolFactory, byte[] bytes) throws TException {
        TDeserializer deser = new TDeserializer(tProtocolFactory);
        Person person = new Person();
        deser.deserialize(person, bytes);
        return person;
    }
}
