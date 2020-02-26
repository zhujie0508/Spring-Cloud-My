package cn.cib.configuration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/26 15:02
 * @Version 1.0
 */
@RestController
@Slf4j(topic = "测试网关-->zull")
@RequestMapping("tzuul")
public class TestZuul {

    @RequestMapping("test1")
    public String testZuul(){
        StringBuffer stringBuffer = new StringBuffer("hfjsdhjfhisdhfiheihfiewhif");
        log.info("hfjsdhjfhisdhfiheihfiewhif");
        return stringBuffer.toString();
    }
}
