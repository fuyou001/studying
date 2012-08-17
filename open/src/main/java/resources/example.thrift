namespace java com.fuyou.thrift

include "demo.thrift"  ##引入别的文件定义的

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
   void testCase4(1:list<demo.Blog> blog)    ##Blog因为别的文件定义 ，所以要加上demo(定义文件前缀)
}