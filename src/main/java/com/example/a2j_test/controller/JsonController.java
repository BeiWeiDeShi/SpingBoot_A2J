package com.example.a2j_test.controller;

import com.example.a2j_test.beans.VersionEntity;
import com.example.a2j_test.beans.base.BaseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  // RestFul style controller layer annotation
@RequestMapping("/app") // Request root path
public class JsonController {

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    // 把方法定义成接口
    public BaseEntity<VersionEntity> getVersion() {
        VersionEntity version = VersionEntity.builder()
            .id(1)
            .version(2)
            .versionStr("2.0.0 Beta")
            .downloadUrl("https://www.baidu.com")
            .build();   // build return object

        // 外层包装
        return BaseEntity.success(version);
    }
}
