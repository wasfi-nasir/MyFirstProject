package com.example.interviews.readFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/api/v1/file")
public class readingFile {
    @GetMapping("/{name}")
    public String read(@PathVariable("name") String name) throws IOException {
        InputStream is = null;
        try {
           is = new ClassPathResource(name).getInputStream();
            String contents = new String(FileCopyUtils.copyToByteArray(is), StandardCharsets.UTF_8);
            return contents;
        } catch (FileNotFoundException  e) {
            throw new CommonException(ErrorEnums.FILE_INVALID, e);

        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
