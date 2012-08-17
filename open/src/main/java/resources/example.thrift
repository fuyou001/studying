namespace java com.fuyou.thrift

include "demo.thrift"  ##�������ļ������

struct BeanExample {
        1: bool booleanPrimive;
        2: byte bytePrimive;
        3: i16 shortPrimive;
        4: i32 intPrimive;
        5: i64 longPrimive;
        6: double doublePrimive;
        7: string stringObject;
        8: binary byteArray; //ByteBuffer
}

service ServiceExample {
  BeanExample getBean(1: i32 anArg; 2: string anOther)
   void testCase4(1:list<demo.Blog> blog)    ##Blog��Ϊ����ļ����� ������Ҫ����demo(�����ļ�ǰ׺)
}