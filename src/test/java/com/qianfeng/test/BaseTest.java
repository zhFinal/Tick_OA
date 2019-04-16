package com.qianfeng.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-bean.xml")
@Transactional
public class BaseTest {

    @Test
    public void Demo1() {
        System.out.println("Hello world!");
    }

    @Test
    public void HashTest(){
        // e99a18c428cb38d5f260853678922e03  ----- 123
        // 7d61f71f34b0305aabc5d1cdd9d2a777 ------ admin
        Md5Hash md5Hash = new Md5Hash("admin" , "abc" ,1);
        System.out.println("密码是：\n" + md5Hash );
    }

}
