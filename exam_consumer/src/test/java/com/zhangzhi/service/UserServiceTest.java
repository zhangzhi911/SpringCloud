//package com.zhangzhi.service;
//
//import  com.zhangzhi.service.UserService;
//import com.thoughtworks.xstream.XStream;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.lang.reflect.Method;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void list() throws Exception {
//        Class<UserService> clazz = UserService.class;
//        Method method = clazz.getMethod("list", String.class, Integer.class);
//
//        String xml = "<object-array>\n" +
//                "  <string>10</string>\n" +
//                "  <int>50</int>\n" +
//                "</object-array>";
//        XStream stream = new XStream();
//        Object[] args = (Object[]) stream.fromXML(xml);
//
//        Object result = method.invoke(userService, args);
//        System.out.println(result);
//    }
//}
