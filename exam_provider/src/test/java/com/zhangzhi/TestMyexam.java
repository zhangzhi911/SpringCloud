package com.zhangzhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@RunWith(SpringRunner.class)
public class TestMyexam {

    @Test
    public void Testexam() {
        System.out.println("测试通过了");
    }


}