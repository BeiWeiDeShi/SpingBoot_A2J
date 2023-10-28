package com.example.a2j_test.controller;

import com.example.a2j_test.beans.UserEntity;
import com.example.a2j_test.beans.VersionEntity;
import com.example.a2j_test.beans.base.BaseEntity;
import org.apache.catalina.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController  // RestFul style controller layer annotation
@RequestMapping("/app") // Request root path
public class JsonController {

    // 把方法定义成接口
    @RequestMapping(value = "/version", method = RequestMethod.GET)
//    @GetMapping(value = "/version")
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

    /**
     * login
     * @param username 用户名
     * @param password 密码
     * @return         用户信息
     */
    @PostMapping(value = "/login")
    public BaseEntity<UserEntity> login(@RequestParam String username, @RequestParam String password) {
        if (!StringUtils.hasLength(username)) return BaseEntity.failed("username is empty!");
        if (!StringUtils.hasLength(password)) return BaseEntity.failed("password is empty!");

        // 模拟从数据库查询的结果
        if (username.equalsIgnoreCase("hello") && password.equalsIgnoreCase("1234")) {
            UserEntity user = UserEntity.builder()
                    .id(1)
                    .age(20)
                    .email("111@qq.com")
                    .username("hello")
                    .password("1234")
                    .gender(0)
                    .createDate(new Date())
                    .build();

            return BaseEntity.success(user);
        }

        return BaseEntity.failed("username or password error !");
    }
}
