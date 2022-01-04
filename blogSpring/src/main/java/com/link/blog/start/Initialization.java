package com.link.blog.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author dl-nest
 * @apiNote 容器创建后的初始化操作
 * @date 2021/12/8 13:04
 */
@Slf4j
@Component
public class Initialization implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        loadConfig();
    }

    private void loadConfig(){
        log.info("初始化自定义类");
    }
}
