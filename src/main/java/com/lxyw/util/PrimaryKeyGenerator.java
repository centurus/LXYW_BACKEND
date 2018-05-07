package com.lxyw.util;

import java.util.UUID;

public class PrimaryKeyGenerator {

    public static String getPrimaryKey(){
       String PrimaryKey= UUID.randomUUID().toString().replaceAll("-", "");
       return PrimaryKey;
    }

    public static void main(String args[]){
        //System.out.print( getPrimaryKey("UserInfo"));
        System.out.print(getPrimaryKey().length());

    }
}
