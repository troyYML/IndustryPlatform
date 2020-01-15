package com.industry.platform;

import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformApplicationTests {

    @Test
    public void contextLoads() {

        byte[] bytes = "123456".getBytes();
        String encodePassword = MD5Encoder.encode(bytes);
        System.out.println(encodePassword);
    }

}
