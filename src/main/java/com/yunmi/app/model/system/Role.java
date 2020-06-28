package com.yunmi.app.model.system;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Role implements Serializable {
    private Integer id;

    private String name;

    private String nameZh;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}