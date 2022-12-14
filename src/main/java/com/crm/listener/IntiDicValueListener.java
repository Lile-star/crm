package com.crm.listener;

import com.crm.workbench.dic.service.DicValueService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

@Component
public class IntiDicValueListener implements ServletContextListener {
    @Resource
    private DicValueService dicValueService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map dicValueMap=dicValueService.getDicValueAll();
        stringRedisTemplate.opsForHash().putAll("dicValue",dicValueMap);
        System.out.println("tomcat开启了");
        System.out.println("xxx");
        System.out.println("这是master的修改");
        System.out.println("xxx");
        System.out.println("push test");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("tomcat关闭了");

    }
}
