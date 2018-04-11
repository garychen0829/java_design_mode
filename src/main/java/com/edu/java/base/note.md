和动态代理有关的有两个类

+ 1.interface InvocationHandler
Object invoke(Object proxy, Method method, Object[] args)

+ 2.Class Proxy
真正表示动态代理的类，提供两个静态方法:

    Class<?> getProxyClass(ClassLoader loader, Class<?>[] interface)
    用来产生代理类，参数要提供interface数组，它会生成这些interface的“虚拟实现”，
    用来冒充真实的对象。
    
    Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
    产生代理对象，多了InvocationHandler参数(只是InvocationHandler接口的实现类)，
    ，当请求分发到它与代理对象关联代理对象后，会自动执行h.invoke(...)方法， 
    invoke方法就是我们用来做N多事情的地方 -_-。


###CGlib实现代理
使用CGLib实现动态代理，完全不受代理类必须实现接口的限制，
而且CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，
比使用Java反射效率要高。唯一需要注意的是，CGLib不能对声明为final的方法进行代理，
因为CGLib原理是动态生成被代理类的子类。

+ 1、被代理类
定义一个类，该类没有实现任何接口
+ 2、拦截器
定义一个拦截器。在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口

    参数：Object为由CGLib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法引用，Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
    返回：从代理实例的方法调用返回的值。
    其中，proxy.invokeSuper(obj,arg)：
    调用代理类实例上的proxy方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）

+ 3、生成动态代理类
Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
首先将被代理类设置成父类，然后设置拦截器，最后执行enhancer.create()动态生成一个代理类，并从Object强制转型成父类型

+ 4、在代理类上调用方法