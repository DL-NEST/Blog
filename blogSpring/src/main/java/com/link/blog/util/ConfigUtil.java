package com.link.blog.util;

import com.link.blog.enums.CodeReturn;
import com.link.blog.exception.CodeExec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

@Slf4j
@Component
public class ConfigUtil {
    // 配置文件流
    Yaml yaml = new Yaml();
    File file = new File("src/main/resources/application.yml");

    /**
     * @apiNote 设置配置
     * @author dl-nest
     * @date 2021/11/25 17:33
     */
    public void setConfig(){
        Map<String, Object> readConfig;
        try {
            readConfig = yaml.load(new FileInputStream(file));
            log.info((String) readConfig.get("config"));
            // 写入
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write(yaml.dump());
//            fileWriter.flush();
//            fileWriter.close();
        } catch (Exception e) {
            throw new CodeExec(CodeReturn.CONFIG_ERROR);
        } finally {
            log.info("修改配置文件《《");
        }
    }
}
