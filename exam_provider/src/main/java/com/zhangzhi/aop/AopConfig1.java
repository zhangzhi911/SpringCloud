package com.zhangzhi.aop;

import com.thoughtworks.xstream.XStream;
import com.zhangzhi.mongo.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Date;

@Component  //变成xml那种
@Aspect  //这个是aop
//@Slf4j  //使用打印
public class AopConfig1 {

    @Autowired
    private MongoTemplate mongoTemplate;


    //    这是切点
    @Pointcut("execution(* com.zhangzhi.service.*.*(..))")
    public void pointcut() {
    }

    /*这里使用的是环绕，也可使用after，befer*/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        获取方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//      获取拦截方法
        Method method = signature.getMethod();
//    获取正在执行方法的参数
        Object[] args = joinPoint.getArgs();
//      正常执行
        Log log = new Log();
        log.setCreateTime(new Date());
        log.setMethod(method.toString()); //method是拦截的方法
        try {
            Object proceed = joinPoint.proceed();
//            log.debug(proceed.toString()+"这是日志");

            log.setLevel("DEBUG");

            XStream xStream = new XStream();
//            log.setMessage(String.format("参数是:{},\n返回值:{}\n", xStream.toXML(args)));  //待看！
            log.setMessage(String.format("参数是:" + xStream.toXML(args) + ", \n返回值是：" + xStream.toXML(proceed) + "\n"));
            //返回值的参数
            mongoTemplate.insert(log);

            //记录正常返回日志
            return proceed;   //把原有方法的返回值返回去
        } catch (Throwable e) {
//            AopConfig1.log.error(e.getMessage());
            log.setLevel("ERROR");
            XStream xStream = new XStream();
            StringWriter writer = new StringWriter();  //流
            e.printStackTrace(new PrintWriter(writer));
//            log.setMessage(String.format("参数是:{},\n异常是:{}\n", xStream.toXML(args), writer.getBuffer()));
            log.setMessage(String.format("参数是:" + xStream.toXML(args) + ", \n异常是：" + writer.getBuffer() + "\n"));
            //返回值的参数
            mongoTemplate.insert(log);
            throw e;
        }
    }
}