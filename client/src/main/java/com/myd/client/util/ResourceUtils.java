package com.myd.client.util;

import com.alibaba.fastjson.JSON;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 10:06
 * @Description:
 */
@UtilityClass
public class ResourceUtils {

    public <T> List<T> loadArry(final String fileName, final Class<T> type) {
        final String context;
        try {
            context = load(fileName);
            return JSON.parseArray(context,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String load(String fileName) throws IOException {
        final InputStream inputStream;
        final File file = org.springframework.util.ResourceUtils.getFile(fileName);
        if(!file.exists()){
            final ClassPathResource classPathResource = new ClassPathResource(fileName);
            inputStream = classPathResource.getInputStream();
        } else {
            inputStream = new FileInputStream(file);
        }

        return doLoad(inputStream);
    }

    private String doLoad(InputStream inputStream) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        final StringBuilder builder = new StringBuilder(256);
        String line;
        while(null != (line = bufferedReader.readLine())){
            builder.append(line);
        }
        return builder.toString();

    }
}
