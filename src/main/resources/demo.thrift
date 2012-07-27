namespace java com.fuyou.thrift   # ע��1   �������ɴ���������ռ䣬������Ҫ�����package���Ӧ��

struct Blog {   #  ע��2.1   ����ʵ�����ƺ����ݽṹ��������ҵ���߼��е�pojo get/set
    1: string topic     #  ע��2.2  �������Ϳ��Բμ� Thrift wiki
    2: binary content
    3: i64    createdTime
    4: string id
    5: string ipAddress
    6: map<string,string> props
  }

service ThriftCase {  #  ע��3    �������ɵ����������ҵ���߼�������Ҫʵ�ִ������ɵ�ThriftCase.Iface�ӿ�
    i32 testCase1(1:i32 num1, 2:i32 num2, 3:string  num3) #ע��4.1 �������ƺͷ����е���Σ�������Ͳμ�wiki
    list<string> testCase2(1:map<string,string>  num1)
    void testCase3()
    void testCase4(1:list<Blog> blog)    #  ע��4.2   list ��thrift�л������������е�һ�֣�list�а�����Blog����������struct�ж����
}