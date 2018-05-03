package com.lxyw.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

    @Getter@Setter
    private Integer totalSize;

    @Getter@Setter
    private List<T> list;


}
