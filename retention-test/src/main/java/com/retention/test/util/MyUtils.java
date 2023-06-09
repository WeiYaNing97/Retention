package com.retention.test.util;
import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 天幕顽主
 * @E-mail: WeiYaNing97@163.com
 * @date 2022年08月02日 14:42
 */
public class MyUtils {


    public static String isEmpty = "Is_Empty";

    /**
     * 根据正则表达式判断字符是否为汉字
     */
    public static boolean isContainChinese( String str) {
        String regex = "[\u4e00-\u9fa5]"; //汉字的Unicode取值范围
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        return match.find();
    }

    /**
     * 该方法主要使用正则表达式来判断字符串中是否包含字母
     * @author fenggaopan 2015年7月21日 上午9:49:40
     * @param cardNum 待检验的原始卡号
     * @return 返回是否包含
     */
    public static boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }

    /**
     * 查询字符串中首个数字出现的位置
     * @param str 查询的字符串
     * @return 若存在，返回位置索引，否则返回-1；
     */
    public static int findFirstIndexNumberOfStr(String str){
        int i = -1;
        Matcher matcher = Pattern.compile("[0-9]").matcher(str);
        if(matcher.find()) {
            i = matcher.start();
        }
        return i;
    }

    /**
     * 判断字符串是否包含数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile(".*[0-9].*");
        return pattern.matcher(str).matches();
    }

    /**
     * 实体类转化为 字符串
     * @param object
     * @return
     */
    public static String getEntityClassString(Object object) {
        //获取实体类 返回的是一个数组 数组的数据就是实体类中的字段
        Field[] fields = object.getClass().getDeclaredFields();
        String sumString = "";
        for (int i = 0; i < fields.length; i++) {
            //有的字段是用private修饰的 将他设置为可读
            fields[i].setAccessible(true);
            try {
                // 输出属性名和属性值
                String nameKey = fields[i].getName();
                Object value = fields[i].get(object);
                if (nameKey.equalsIgnoreCase("serialVersionUID")){
                    continue;
                }
                sumString = sumString  + nameKey + ":\"" + (value == null?isEmpty:value)+"\",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sumString.substring(0,sumString.length()-1);
    }



    /**
     * 文章字段 换行夫 规范成\r\n
     * @param article
     * @return
     */
    public static String trimString(String article) {
        //String lineSeparator = System.lineSeparator(); // 获取当前操作系统的换行符
        // 读取文章并按行存入数组
        String[] lines = article.split("\\r?\\n|\\r"); // 使用正则表达式按照任意一种换行符进行分割
        /*repaceWhiteSapce*/
        /*for (int num=0;num<lines.length;num++){
            lines[num] = repaceWhiteSapce(lines[num]);
        }*/
        /*字符串数组以\r\n拼接成字符串*/
        return repaceWhiteSapce(String.join("\r\n", lines));
    }

    /*
    Java时间设为二十四小时制和十二小时制的区别：
    1) 二十四小时制： “yyyy-MM-dd HH:mm:ss”
    2)十二小时制： “"yyyy-MM-dd hh:mm:ss"”
    */
    //获取时间 格式自定
    //例如：type  =  "yyyy-MM-dd hh:mm:ss"
    public static String getDate(String type){
        String time = new SimpleDateFormat(type).format(new Date());
        return time;
    }

    public static String getDatetoString(Date dateTime){
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateTime);
        return time;
    }


    public static Date getStringtoData(String time){
        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    //时间排序 由大到小
    public static List<Date> sortDate(List<Date> dateList){
        dateList.sort((a1,a2) ->{
            return a1.compareTo(a2);
        });
        return dateList;
    }


    /**
     * @method: 进度条
     * @Param: [总数, 完成数]
     * @return: java.lang.String
     * @Author: 天幕顽主
     * @E-mail: WeiYaNing97@163.com
     */
    public static String progressBar(double number1,double number2) {
        return (int)(number2/number1*100)+"%";
    }

    /**
     * @method: 多个连续空格 改为 多个单空格
     * @Param: [original]
     * @return: java.lang.String
     * @Author: 天幕顽主
     * @E-mail: WeiYaNing97@163.com
     */
    public static String repaceWhiteSapce(String original){
        StringBuilder sb = new StringBuilder();
        boolean isFirstSpace = false;//标记是否是第一个空格
        // original = original.trim();//如果考虑开头和结尾有空格的情形
        char c;
        for(int i = 0; i < original.length(); i++){
            c = original.charAt(i);
            if(c == ' ' || c == '\t')//遇到空格字符时,先判断是不是第一个空格字符
            {
                if(!isFirstSpace)
                {
                    sb.append(c);
                    isFirstSpace = true;
                }
            }
            else{//遇到非空格字符时
                sb.append(c);
                isFirstSpace = false;
            }
        }
        return sb.toString();
    }

    /**
     * 时间由大到小排序
     * @param dateList
     * @return
     */
    public static List<Date> sort(List<Date> dateList){
        dateList.sort((a1,a2) ->{
            return a1.compareTo(a2);
        });
        return dateList;
    }

    /**
     * 删除数组空文本返回新数组
     * @param strArray
     * @return
     */
    public static String[] removeArrayEmptyTextBackNewArray(String[] strArray) {
        List<String> strList= Arrays.asList(strArray);
        List<String> strListNew=new ArrayList<>();
        for (int i = 0; i <strList.size(); i++) {
            if (strList.get(i)!=null&&!strList.get(i).equals("")){
                strListNew.add(strList.get(i));
            }
        }
        String[] strNewArray = strListNew.toArray(new String[strListNew.size()]);
        return   strNewArray;
    }


    /**
     * 判断字符串中是否包含数字
     * @param source 待判断字符串
     * @return 字符串中是否包含数字，true：包含数字，false：不包含数字
     */
    public static boolean containDigit(String source) {
        char ch;
        for(int i=0; i<source.length();i++){
            ch = source.charAt(i);
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串集合元素是否都包含数字
     * @param stringList
     * @return
     */
    public static boolean thereAreNumbersInTheSet(List<String> stringList) {
        for (String string:stringList){
            /*如果不包含数字 则返回false */
            if (!containDigit(string)){
                return false;
            }
        }
        return true;
    }

    /*判断 字符串 元素是否都包含 数字*/
    public static boolean thereAreNumbers(String string) {
        /*如果不包含数字 则返回false */
        return containDigit(string);
    }


    /*String*/
    /**
     * 去除字符串尾部非字符串部分
     * @param str
     * @return
     */
    public static String removeNonNumericSuffix(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int index = str.length() - 1;
        while (index >= 0 && !Character.isDigit(str.charAt(index))) {
            index--;
        }
        return str.substring(0, index + 1);
    }
    /**
     * 根据字符串 根据字符串（忽略大小写）分割为字符串数组
     *
     * "(?i)"表示忽略大小写
     *
     * @param string  被分割字符串
     * @param str   分割关键词
     * @return
     */
    public static String[] splitIgnoreCase(String string,String str){
        return string.split("(?i)"+str);
    }

    /*Double*/
    /**
     * 字符串 转化为  Double
     * @param str
     * @return
     */
    public static double stringToDouble(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }
    /**
     * 字符串截取double值
     * @param input
     * @return
     */
    public static List<Double> StringTruncationDoubleValue(String input) {
        List<Double> doubleList = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            double value = Double.parseDouble(matcher.group());
            doubleList.add(value);
        }
        return doubleList;
    }
    /**
     * 判断 double值 是否在阈值内
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    /*判空*/
    /**
     * 判断集合是否为空， 为空返回true
     * 集合判空
     * @param collection
     * @return
     */
    public static boolean isCollectionEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty() || collection.size() == 0;
    }
    /**
     * 判断Map集合是否为空， 为空返回true
     * @param map
     * @return
     */
    public static boolean isMapEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty() || map.size() == 0;
    }

    /**
     * 判断一个字符串是否包含另一个字符串(忽略大小写)
     * @param primary
     * @param keywords
     * @return
     */
    public static boolean containIgnoreCase(String primary,String keywords) {
        return primary.toUpperCase().indexOf(keywords.toUpperCase())!=-1;
    }

}