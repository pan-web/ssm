package com.pan.ui;

import com.pan.Dao.IAccountDao;
import com.pan.Service.Impl.AccountServiceImpl;
import com.pan.Service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个变现层，用于调用业务层
 */
public class client {
    /**
     * 获取Spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *     ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。
     *     FileSystemXmlApplication:它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *     AnnotationConfigApplication：
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext:  单例对象用
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中的配置对象。
     *  BeanFactory:   多例对象用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正创建对象。
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        // IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        //System.out.println(as);
        //System.out.println(adao);
        as.saveAccount();

        //手动关闭容器
        ac.close();

        //---------BeanFactory-------
        /*Resource resource = new ClassPathResource("bean.xml");
       BeanFactory factory = new XmlBeanFactory(resource);
       IAccountService as = (IAccountService)factory.getBean("accountService");
       System.out.println(as);*/
    }
}
