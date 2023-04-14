package com.retention.test;

import ch.qos.logback.core.util.FileUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class CustomConfigurationController {

    private static Yaml yaml = new Yaml();

    public static void getValue() {
        String value = obtainConfigurationFileParameterValues("光衰.H3C.转译.GE");
        System.err.println(value);
    }

    public static String obtainConfigurationFileParameterValues(String key) {
        String value = null;
        try {
            InputStream inputStream = new FileInputStream(new File(getRelativePath("customconfiguration.yml")));
            Map<String, Object> map = yaml.load(inputStream);
            Object objectValue = getValue(key, map);
            if (objectValue instanceof String){
                value = (String) objectValue;
            }
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Object getValue(String key, Map<String, Object> map) {
        String[] keys = key.split("\\.");
        if (keys.length == 1) {
            return map.get(keys[0]);
        } else {
            String subKey = key.substring(keys[0].length() + 1);
            Object subMap = map.get(keys[0]);
            if (subMap instanceof Map) {
                return getValue(subKey, (Map<String, Object>) subMap);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取相对路径
     * @param filePath  文件名称
     * @return
     * @throws URISyntaxException
     */
    public static String getRelativePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL url = classLoader.getResource("");
        File file = new File(url.toURI());
        return file.getAbsolutePath() + "/" + filePath;
    }
}
