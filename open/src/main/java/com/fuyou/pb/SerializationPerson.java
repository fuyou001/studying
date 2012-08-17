package com.fuyou.pb;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-24
 * Time: ����11:18
 * To change this template use File | Settings | File Templates.
 */
public class SerializationPerson {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Person john =
                AddressBookProtos.Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhone(
                                AddressBookProtos.Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(AddressBookProtos.Person.PhoneType.HOME))
                        .build();
        System.out.println(john);
        byte[] personBytes = john.toByteArray();

        //���ֲ�ͬ��ʽʵ�ַ���
        AddressBookProtos.Person john2 = AddressBookProtos.Person.getDefaultInstance().newBuilderForType().mergeFrom(personBytes).build();
        //AddressBookProtos.Person john2 = AddressBookProtos.Person.parseFrom(personBytes);
        System.out.println("john euals john2:"+(john.equals(john2)));
        System.out.println(john2);


    }
}
