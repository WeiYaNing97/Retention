package com.retention.test.demo;

/**
 * 枚举测试类02
 */
public abstract class enumeration02 {
    public abstract void show();

    private String name;

    private enumeration02(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final enumeration02 MON = new enumeration02("星期一") {
        @Override
        public void show() {
            System.out.println("这个枚举对象表示的是：" + getName());
        }
    };
    public static final enumeration02 TUE = new enumeration02("星期二") {
        @Override
        public void show() {
            System.out.println("今天是" + getName());
        }
    };
    public static final enumeration02 WED = new enumeration02("星期三") {
        @Override
        public void show() {
            System.out.println("该对象表示的是" + getName());
        }
    };

    public static void main(String[] args) {
        enumeration02 m = enumeration02.MON;
        System.out.println(m.getName());
        m.show();
    }
}
