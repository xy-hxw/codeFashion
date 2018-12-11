装饰器模式
1：装饰器和实现类实现同一个接口
2：私有化一个具体的实现类
3：装饰器接受实现类对象作为完参数
4：装饰器调用方法
5：接口方法中再次调用该接口的方法

java中的IO流使用的装饰器模式
BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File("")));