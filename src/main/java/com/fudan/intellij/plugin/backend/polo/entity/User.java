package com.fudan.intellij.plugin.backend.polo.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Delete;

@Data
public class User {

    private String username;

    private String email;

    private String phone;
}
