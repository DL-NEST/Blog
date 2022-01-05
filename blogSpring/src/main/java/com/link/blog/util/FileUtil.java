package com.link.blog.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * @author pmd
 */
@Component
public class FileUtil {
    @Value("${file.upload.path}")
    private String rootPath;

    public String readString(String filepath) {
        File file = new File(filepath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            StringBuilder content = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        } finally {
            try {
                //关闭流释放资源
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写入文件（覆盖写入）
     */
    public Boolean writeString(String filepath, String content) {
        File file = new File(filepath);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                //关闭流释放资源
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除配置文件
     */
    public Boolean delFile(String filepath) {
        String resultInfo = null;
        String path = new String(rootPath.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        File file = new File(path + filepath + "/config.json");
        if (file.exists()) {
            return file.delete();
        } else {
            return true;
        }
    }

    /**
     * 写入json文件(没有会创建，文件存在会覆盖)
     */
    public Boolean writeJson(String filepath, Object writeData) {
        String path = new String(rootPath.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String jsonString = JSON.toJSONString(writeData);
        System.out.println(path + filepath + "/config.json");
        return writeString(path + filepath + "/config.json", jsonString);
    }
}