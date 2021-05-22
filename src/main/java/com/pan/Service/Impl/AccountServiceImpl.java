package com.pan.Service.Impl;

import com.pan.Dao.IAccountDao;
import com.pan.Dao.Impl.AccountDaoImpl;
import com.pan.Service.IAccountService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;


/**
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println ("对象创建了");
    }
    public void init(){


        System.out.println("对象初始化了。");


    }



    public void saveAccount(){


        System.out.println("service中的save方法执行了。。");


    }

    public void destroy(){


        System.out.println("对象销毁了。。");


    }
}
