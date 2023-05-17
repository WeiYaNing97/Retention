package com.retention.test.demo;

/**
 * 枚举测试类03
 */
public enum enumeration03 {
    MON("星期一") {
        public void show() {
            System.out.println("这个枚举对象表示的是：" + getName());
        }
    },
    TUE("星期二") {
        public void show() {
            System.out.println("今天是：" + getName());
        }
    },
    WED("星期三") {
        public void show() {
            System.out.println("该对象表示：" + getName());
        }
    };
    private String name;

    private enumeration03(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void show();



    public static void main(String[] args) {
        enumeration03 wd1 = enumeration03.MON;
        System.out.println(wd1.getName());
        wd1.show();
        enumeration03 wd2 = enumeration03.TUE;
        System.out.println(wd2.getName());
        wd2.show();
    }
}
