package com.zhangzhi.aop;//package com.zhangzhi.aop;
//
//import com.zhangzhi.mongo.Log;
//import com.thoughtworks.xstream.XStream;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.lang.reflect.Method;
//import java.util.Date;
//
//@Component
//@Aspect
//public class AopConfig {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    // 定义切点
//    @Pointcut("execution(* com.zhangzhi.service.*.*(..))")
//    public void pointcut() {
//    }
//
//    // 定义环绕通知，切点为上面的切点
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 获取方法签名
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        // 获取被拦截到的方法
//        Method method = signature.getMethod();
//        // 获取正在执行的方法的参数
//        Object[] args = joinPoint.getArgs();
//
//        Log log = new Log();
//        log.setCreateTime(new Date());
//        log.setMethod(method.toString());
//
//        try {
//            // 正常执行原方法
//            Object result = joinPoint.proceed();
//            // 记录正常返回的日志
//            log.setLevel("DEBUG");
//            XStream xstream = new XStream();
//            log.setMessage(String.format("参数是:" + xstream.toXML(args) + ", \n返回值是：" + xstream.toXML(result) + "\n"));
//            mongoTemplate.insert(log);
//
//            // 把原有方法的返回值返回
//            return result;
//        } catch (Throwable e) {
//            // 记录异常返回的日志
//            log.setLevel("ERROR");
//            XStream xstream = new XStream();
//            StringWriter writer = new StringWriter();
//            e.printStackTrace(new PrintWriter(writer));
//            log.setMessage(String.format("参数是:" + xstream.toXML(args) + ", \n异常是：" + writer.getBuffer() + "\n"));
//            mongoTemplate.insert(log);
//            throw e;
//        }
//    }
//}
