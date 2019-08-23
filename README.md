##面试

###SpringMVC的流程

1）用户发送请求至前端控制器DispatcherServlet；

2）DispatcherServlet收到请求后，调用HandlerMapping处理器映射器，请求获取Handler;

3）处理器映射器根据请求URL找到具体的处理器，生成处理器对象及处理器拦截器一并返回给DispatcherServlet；

4）DispatcherServlet调动HandlerAdapter处理器适配器；

5）HandlerAdapter经过适配调用具体处理器(Handler，也叫后端控制器 就是调用Controller中的方法)；

6）Handler 执行完成返回ModelAndView；

7）HandlerAdapter将Handler执行结果ModelAndView返回给DIspatcherServlet；

8）DispatcherServlet将ModelAndView传给ViewResolver视图解析器进行解析；

9）ViewResolver解析后返回具体View；

10）DispatcherServlet对View进行渲染视图

11）DIspatcherServlet响应用户。

### HTTP协议中的POST和GET的区别

1）GET在浏览器回退时是无害的，而POST会再次提交请求

2）GET产生的URL可以被放到书签中，而POST不会，除非手动设置

3）GET请求只能进行URL编码，而POST支持多种编码方式。

4）GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留

5）GET请求在URL中传送的参数是有长度限制的，而POST没有

6）对于参数的数据类型，GET只接受ASCII字符，而POST没有限制

7）GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。

8）GET参数通过URL传递,POST放在Request Body中

**注：** HTTP的底层是TCP/IP，所以GET和POST的底层也是TCP/IP。GET/POST都是TCP链接，GET和POST能做的事情是一模一样的。你要给GET加上RequestBody，给POST带上URL参数，技术上是完全行得通的。

**GET和POST还有一个重大的区别，GET会产生一个TCP数据包，而POST会产生两个TCP数据包。** 

> GET方式的请求，浏览器会把httpheader和data一并发送出去，服务器响应200

> POST方式的请求，浏览器会先发送header，服务器响应100 continue，浏览器再发送data，服务器响应200 OK

### 多线程

#### 多线程定义

多线程就是多个线程同时运行或交替运行。单核CPU的话是顺序执行。也就是交替运行。多核CPU的话，因为每个CPU有自己的运算器。所以在多个CPU中可以同时运行。

#### 使用多线程意义

1）使用线程可以把占据长时间的程序中的任务放到后台去处理

2）程序运行速度可能加快

#### 多线程对象有哪些常用方法

join、wait、sleep、yield、notify、notifyAll

#####sleep
使当前线程暂停执行一段时间，让其他线程有机会继续执行。但**并不释放对象锁**。也就是说如果有synchronized同步块，其他线程仍然不能访问共享数据。sleep方法可以是低优先级的线程得到执行机会，当然也可以让同优先级、高优先级的线程有执行的机会。**sleep会自动苏醒，并自动执行sleep后面的方法**

#####wait
wait方法使当前线程暂停执行并**释放对象锁标识，wait方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的notify或者notifyAll方法，才能苏醒**

#####join
join()方法使调用该方法的线程在此之前执行完毕，也就是等待该方法的线程执行完毕后再往下继续执行。注意该方法也需要捕捉异常。该影响只存在于执行join方法的线程和调用该线程的线程之间。**如在t1线程中调用t2.join(),则需要t2线程执行完后t1方能继续执行**

#####yield
该方法与sleep()类似，只是不能由用户指定暂停多长时间，并且yield（）方法只能让同优先级的线程有执行的机会。

#####notify、notifyAll
当调用notify()方法 后，将从对象的等待池中移走一个任意的线程并放到锁标志等待池中，只有锁标志等待池中线程能够获取锁标志；如果锁标志等待池中没有线程，则 notify()不起作用。notifyAll()则从对象等待池中移走所有等待那个对象的线程并放到锁标志等待池中。

### MVC的理解

MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写，一种软件设计典范，用一种业务逻辑、数据、界面显示分离的方法组织代码，将业务逻辑聚集到一个部件里面，在改进和个性化定制界面及用户交互的同时，不需要重新编写业务逻辑。MVC被独特的发展起来用于映射传统的输入、处理和输出功能在一个逻辑的图形化用户界面的结构中。

**Model（模型）：**数据模型，提供要展示的数据，因此包含数据和行为，主要提供了模型数据查询和模型数据的状态更新等功能，包括数据和业务。主要使用的技术：数据模型：实体类（JavaBean），数据访问：JDBC，Hibernate等。

**View（视图）**：负责进行模型的展示，一般就是我们见到的用户界面，比如JSP，Html等

**Controller（控制器）：**接收用户请求，委托给模型进行处理（状态改变），处理完毕后把返回的模型数据返回给视图，由视图负责展示。主要使用的技术：servlet，Struts中的Action类等。

​    MVC是一个框架模式，它强制性的使应用程序的输入、处理和输出分开。使用MVC应用程序被分成三个核心部件：模型、视图、控制器。它们各自处理自己的任务。最典型的MVC就是JSP + servlet + javabean的模式。

##### MVC的优缺点

　　**优点：分层，结构清晰，耦合性低，大型项目代码的复用性得到极大的提高，开发人员分工明确，提高了开发的效率，维护方便，降低了维护成本。**

　　**缺点：简单的小型项目，使用MVC设计反而会降低开发效率，层和层虽然相互分离，但是之间关联性太强，没有做到独立的重用。**

###BeanFactory和FactoryBean的区别

BeanFactory和FactoryBean都是Spring Beans模块下的接口
**BeanFactory**是spring简单工厂模式的接口类，spring IOC特性核心类提供从工厂类中获取bean的各种方法，是所有bean的容器。
**FactoryBean**仍然是一个bean，但不同于普通bean，它的实现类最终也需要注册到BeanFactory中。它也是一个简单工厂模式的接口类，但是生产的是单一类型的对象，与BeanFactory生产多种类型对象不同，**是一个能生产或修饰对象生成的工厂Bean**

###ThreadLocal
内部存在一个ThreadLocalMap来维护数据，让每个ThreadLocal的数据存放在ThreadLocalMap中。
####set方法

```java
public void set(T value) {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
    }
```

####get方法

```
public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
```

### getMap方法

```java 
 ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
```

set和get方法都是先找出当前的线程，然后获取当前的Thread的ThreadLocalMap对象，如果没有ThreadLocalMap对象则创建一个新的ThreadLocalMap对象，如果有，就通过ThreadLocalMap的方法存入对象或者取出对象，ThreadLocalMap维护的是一个弱引用的key,当value的指向为空时，GC会自动回收ThreadLocalMap对象

###Spring在代码中获取bean的几种方式

#####方法一：在初始化时保存ApplicationContext对象 ：

```java
ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml"); 
ac.getBean("userService");
 
//比如：在application.xml中配置：
<bean id="userService" class="com.cloud.service.impl.UserServiceImpl"></bean>
```

说明：这样的方式适用于Spring框架的独立应用程序，须要程序通过配置文件初始化Spring。

#####方法二：通过Spring提供的工具类获取ApplicationContext对象

```java
ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc); 
ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(ServletContext sc); 
ac1.getBean("beanId"); 
ac2.getBean("beanId");  
```

说明：这样的方式适合于採用Spring框架的B/S系统，通过ServletContext对象获取ApplicationContext对象。然后在通过它获取须要的类实例。上面两个工具方式的差别是，前者在获取失败时抛出异常。后者返回null。

#####方法三：实现接口ApplicationContextAware：（推荐）

```java
/**
 * Spring ApplicationContext 工具类
*/
@SuppressWarnings("unchecked")
@Component
public class SpringUtils implements ApplicationContextAware {
 
    private static ApplicationContext applicationContext;
 
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
 
    public static <T> T getBean(String beanName) {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else{
            return null;
        }
    }
 
    public static <T> Map<String, T> getBeansOfType(Class<T> baseType){
        return applicationContext.getBeansOfType(baseType);
    }
}
```
说明：实现该接口的setApplicationContext(ApplicationContext context)方法，并保存ApplicationContext 对象。Spring初始化时，扫描到该类，就会通过该方法将ApplicationContext对象注入。然后在代码中就可以获取spring容器bean了。例如：

LoadExploreTree bean = SpringUtils.getBean("loadExploreTree");

### Spring中Bean的作用域

#####① singleton

使用该属性定义Bean时，IOC容器仅创建一个Bean实例，IOC容器每次返回的是同一个Bean实例。

#####② prototype

使用该属性定义Bean时，IOC容器可以创建多个Bean实例，每次返回的都是一个新的实例。

#####③ request

该属性仅对HTTP请求产生作用，使用该属性定义Bean时，每次HTTP请求都会创建一个新的Bean，适用于WebApplicationContext环境。

#####④ session

该属性仅用于HTTP Session，同一个Session共享一个Bean实例。不同Session使用不同的实例。

#####⑤ global-session

该属性仅用于HTTP Session，同session作用域不同的是，所有的Session共享一个Bean实例。

### @Autowired和@Resource

@Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了。@Resource有两个属性是比较重要的，分是name和type，Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
　　@Resource装配顺序
　　1. 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
　　2. 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
　　3. 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
　　4. 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配；

@Autowired 与@Resource的区别：

 

1、 @Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。

2、 @Autowired默认按类型装配（这个注解是属业spring的），默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，如：@Autowired(required=false) ，如果我们想使用名称装配可以结合@Qualifier注解进行使用，如下：

```java
@Autowired()@Qualifier("baseDao")
privateBaseDao baseDao;
```

3、@Resource（这个注解属于J2EE的），默认按照名称进行装配，名称可以通过name属性进行指定，如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找，如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。

```java
@Resource(name="baseDao")
privateBaseDao baseDao;
```

###Java中静态代码块、构造代码块、构造函数、普通代码块

#### 1、静态代码块

#####格式

```
public class CodeBlock {
    static{
        System.out.println("静态代码块");
    }
}
```



##### 执行时机

　　静态代码块在类被加载的时候就运行了，而且只运行一次，并且优先于各种代码块以及构造函数。如果一个类中有多个静态代码块，会按照书写顺序依次执行。后面在比较的时候会通过具体实例来证明。

####2、构造代码块

#####格式

```
public class CodeBlock {
    {
        System.out.println("构造代码块");
    }
}
```

##### 执行时机

　　构造代码块在创建对象时被调用，每次创建对象都会调用一次，但是优先于构造函数执行。需要注意的是，听名字我们就知道，构造代码块不是优先于构造函数执行，而是依托于构造函数，也就是说，如果你不实例化对象，构造代码块是不会执行的

#### 3、构造函数块

##### 格式

```java
public class CodeBlock {
    CodeBlock(){
    		System.out.println("构造函数块");
    }
}
```

##### 执行时机

​		每次执行构造方法时，就执行一次构造函数块。



###死锁

#### 死锁的条件

**互斥条件(Mutual exclusion)     ：资源不能被共享，只能由一个进程使用。**

**请求与保持条件(Hold and wait)：进程已获得了一些资源，但因请求其它资源被阻塞时，对已获得的资源保持不放。     **

**不可抢占条件(No pre-emption)    ：有些系统资源是不可抢占的，当某个进程已获得这种资源后，系统不能强行收回，只能由进程使用完时自己释放**。    

**循环等待条件(Circular wait)      ：若干个进程形成环形链，每个都占用对方申请的下一个资源。处理死锁的策略**

#### 解决死锁的策略

(1) 死锁预防：破坏导致死锁必要条件中的任意一个就可以预防死锁。例如，要求用户申请资源时一次性申请所需要的全部资源，这就破坏了保持和等待条件；将资源分层，得到上一层资源后，才能够申请下一层资源，它破坏了环路等待条件。预防通常会降低系统的效率。

(2) 死锁避免：避免是指进程在每次申请资源时判断这些操作是否安全，例如，使用银行家算法。死锁避免算法的执行会增加系统的开销。

(3) 死锁检测：死锁预防和避免都是事前措施，而死锁的检测则是判断系统是否处于死锁状态，如果是，则执行死锁解除策略。

(4) 死锁解除：这是与死锁检测结合使用的，它使用的方式就是剥夺。即将某进程所拥有的资源强行收回，分配给其他的进程。

### JDK和JRE

JDK是Java Development Kit，它是功能齐全的Java SDK。它拥有JRE所拥有的一切，还有编译器（javac）和工具（如javadoc和jdb）。它能够创建和编译程序。

JRE 是 Java运行时环境。它是运行已编译 Java 程序所需的所有内容的集合，包括 Java虚拟机（JVM），Java类库，java命令和其他的一些基础构件。但是，它不能用于创建新程序。



#### SpringMVC 初始化

##### Controller方法注册

```
RequestMappingHandlerMapping.class

RequestMapping requestMapping = (RequestMapping)AnnotatedElementUtils.findMergedAnnotation(element, RequestMapping.class);
```

通过AnnotatedElementUtils工具类来判断方法是否有@RequestMapping注解

然后注册到Spring中



###Bean的创建和BeanFactory创建

####Spring容器的加载

```
 准备BeanFactory
 this.prepareBeanFactory(beanFactory);
 设置BeanFactory后置处理器
 this.postProcessBeanFactory(beanFactory); 
 通过反射调用BeanFactory的后置方法
 this.invokeBeanFactoryPostProcessors(beanFactory);
 注册Bean的后置处理器
 this.registerBeanPostProcessors(beanFactory);
 对上下文中的消息源进行初始化
 this.initMessageSource();
 初始化上下文中的事件机制
 this.initApplicationEventMulticaster();
 初始化其他的特殊bean
 this.onRefresh();
 检查监听bean并且将这些bean向容器注册
 this.registerListeners();
 实例化所有的(non-lazy-init)单例
 this.finishBeanFactoryInitialization(beanFactory);
 发布容器事件，结束refresh过程
 this.finishRefresh();
```

### JVM内存模型

####线程独占

#####栈

>也叫方法栈，是线程私有的，线程在执行每个方法是都会同时创建一个栈区，用来存储局部变量表、操作栈、动态链接、方法出口等信息，调用方法时执行入栈，方法返回时进行出栈，

#####本地方法栈

> 与栈类似，也是用来储存线程执行方法的信息，不同的是：执行Java方法时使用的是栈，执行native方法时则使用的是本地方法栈，

#####程序计数器

> 保存着当前线程所执行的字节码位置，每个线程工作时都有一个独立的计数器，程序计数器只为执行Java方法服务，执行native方法时，程序计数器为空。

 

#### 线程共享

##### 堆

> 是JVM管理的内存中最大的一块，被所有的线程共享。目的是为了存放对象的实例，几乎所有的对象实例都会放在堆中，当堆内存里没有可用空间时，会抛出OOM异常，根据对象存活的周期不同，进行分代管理。由垃圾回收器进行垃圾回收管理。

##### 方法区

> 方法区也是各个线程共享的区域，又叫非堆区，用于存储被虚拟机加载的类信息、常量、静态变量、即时编译器优化后的代码的数据。Java1.7的永久代和1.8的metaspace就是方法区的实现

#### Spring 事务的传播行为

##### Required 

> 需要 如果存在一个事务，则支持当前事务，如果没有事务则开启一个新的事务

##### Supports

>支持 如果存在一个事务，则支持当前事务，如果没有则以非事务是的方式执行

Mandatory

>必要 如果存在事务，则支持当前事务，如果没有活动的事务，则抛出异常

##### required_new

>总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起

Not_support

> 总是以非事务的执行，并挂起任何存在的事务

##### Never

> 绝不，总是以非事务的方式执行，如果存在一个活动的事务，则抛出异常

##### Nested

> 嵌套的 如果有就嵌套，没有则开启事务
