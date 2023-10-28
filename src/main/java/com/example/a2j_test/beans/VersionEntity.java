package com.example.a2j_test.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data  // 自动提供了 Get 和 Set 方法
@Builder
public class VersionEntity implements Serializable {

    private Integer id;
    private Integer version; // 版本号
    private String  versionStr;  // 版本号 2.0.3.Beta
    private String  downloadUrl;


}
