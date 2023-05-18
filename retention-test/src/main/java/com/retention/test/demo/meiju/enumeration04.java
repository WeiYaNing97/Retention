package com.retention.test.demo.meiju;

/**
 * 枚举测试类04
 */
public enum enumeration04 {
    D1,
    D2,
    D3;
    public String toString() {
        return this.name().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(enumeration04.D1.ordinal());//0
        System.out.println(enumeration04.D3.ordinal());//2
        System.out.println(enumeration04.D2.ordinal());//1
        System.out.println(enumeration04.D1.compareTo(enumeration04.D3));
        System.out.println(enumeration04.D2.compareTo(enumeration04.D2));
        System.out.println(enumeration04.D3.compareTo(enumeration04.D1));
        System.out.println(enumeration04.D1.name());
        System.out.println(enumeration04.D1.toString());
        enumeration04[] vs = enumeration04.values();
        for (enumeration04 d : vs) {
            System.out.println(d);
        }
    }
}
