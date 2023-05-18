package com.retention.test.demo.meiju;

/**
 * 枚举测试类01
 */
public enum enumeration01 {
    MON("星期一"),
    TUE("星期二"),
    WED("星期三");
    private String name;
    private enumeration01(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        enumeration01 wd1 = enumeration01.MON;
        System.err.println(wd1.getName());
    }
}
