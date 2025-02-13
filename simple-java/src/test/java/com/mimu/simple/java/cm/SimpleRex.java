package com.mimu.simple.java.cm;

import org.junit.Test;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luyahui
 * @date 2023/10/19
 * @description 正则表达式 可 参考
 * @see Pattern doc 文档
 */
public class SimpleRex {


    /**
     * 位置匹配
     * ^ 匹配行开头；
     * $ 匹配行结尾；
     * \b 匹配一个单词边界 即左边 \w 右边[^\w] 或者 左边[^\w] 右边 \w;
     */

    @Test
    public void positionRexTest() {
        String prefix = "^ab";
        System.out.println(Pattern.matches(prefix, "ab")); // true
        System.out.println(Pattern.matches(prefix, "abc")); // false
        System.out.println();
        String suffix = "ab$";
        System.out.println(Pattern.matches(suffix, "ab")); // true
        System.out.println(Pattern.matches(suffix, "cab")); // false

    }

    /**
     * 单字符匹配
     * \d 匹配数字
     * \D 匹配非数字
     * \w 匹配单个 字母数字下划线汉字
     * \W 匹配非 \w 的单个字符
     * \s 匹配空白字符 包括 空格，换行符，
     * \S 匹配非 \s
     * . 匹配除换行符之外的 任意字符
     */

    @Test
    public void singleWordTest() {
        String dRegx = "ab\\d";
        System.out.println(Pattern.matches(dRegx, "ab1")); // true
        System.out.println(Pattern.matches(dRegx, "ab12")); // false
        System.out.println(Pattern.matches(dRegx, "abc")); // false
        System.out.println();
        String DRegx = "ab\\D";
        System.out.println(Pattern.matches(DRegx, "ab1")); // false
        System.out.println(Pattern.matches(DRegx, "abc")); // true
        System.out.println(Pattern.matches(DRegx, "abcd")); // false
        System.out.println();
        String wRegx = "ab\\w";
        System.out.println(Pattern.matches(wRegx, "ab1")); // true
        System.out.println(Pattern.matches(wRegx, "abc")); // true
        System.out.println(Pattern.matches(wRegx, "abcd")); // false
        System.out.println();
        String WRegx = "ab\\W";
        System.out.println(Pattern.matches(WRegx, "ab^")); // true
        System.out.println(Pattern.matches(WRegx, "ab^a")); // false
        System.out.println(Pattern.matches(WRegx, "abc")); // false
        System.out.println();
        String sRegx = "ab\\s";
        System.out.println(Pattern.matches(sRegx, "ab ")); // true
        System.out.println(Pattern.matches(sRegx, "ab\n")); // true
        System.out.println(Pattern.matches(sRegx, "ab   ")); // false
        System.out.println();
        String dotRegx = "ab.";
        System.out.println(Pattern.matches(dotRegx, "ab ")); // true
        System.out.println(Pattern.matches(dotRegx, "abc")); // true
        System.out.println(Pattern.matches(dotRegx, "abcd")); // false
        System.out.println();

    }

    /**
     * 单字符
     * [abc] a, b, or c (simple class)
     * [^abc] Any character except a, b, or c (negation)
     * [a-zA-Z] a through z or A through Z, inclusive (range)
     * [a-d[m-p]] a through d, or m through p: [a-dm-p] (union)
     * [a-z&&[def]] d, e, or f (intersection)
     * [a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)
     * [a-z&&[^m-p]] a through z, and not m through p: [a-lq-z](subtraction)
     */

    @Test
    public void characterTest() {
        String aRegx = "a[bc]";
        System.out.println(Pattern.matches(aRegx, "ab")); // true
        System.out.println(Pattern.matches(aRegx, "ac")); // true
        System.out.println(Pattern.matches(aRegx, "abc")); // false
        System.out.println();
        String aThroughRegx = "[a-c]";
        System.out.println(Pattern.matches(aThroughRegx, "a")); // true
        System.out.println(Pattern.matches(aThroughRegx, "ab")); // flase
        System.out.println(Pattern.matches(aThroughRegx, "abc")); // false
        System.out.println();
    }

    /**
     * 单字符 X
     * X?  X, once or not at all
     * X* X, zero or more times
     * X+ X, one or more times
     * X{n} X, exactly n times
     * X{n,} X, at least n times
     * X{n,m} X, at least n but not more than m times
     */

    @Test
    public void qualifyTest() {
        String aRegx = "abc?"; // 这里标识c出现的次数
        System.out.println(Pattern.matches(aRegx, "ab")); // true
        System.out.println(Pattern.matches(aRegx, "c")); // false
        System.out.println(Pattern.matches(aRegx, "abc")); // true
        System.out.println(Pattern.matches(aRegx, "abcabc")); // false
        System.out.println();
        String leastNRegx = "abc{0,1}"; // 这里标识c出现的次数
        System.out.println(Pattern.matches(leastNRegx, "ab")); // true
        System.out.println(Pattern.matches(leastNRegx, "abc")); // true
        System.out.println(Pattern.matches(leastNRegx, "abcabc")); // false
        System.out.println(Pattern.matches(leastNRegx, "abcabc")); // false
        System.out.println();
    }

    @Test
    public void test() {
        String reg = "^https?://([\\w-]+.)+[\\w-]+(/[\\w-./?&=]*)?$";
        System.out.println(Pattern.matches(reg, "https://domain.path.com?id=07701020028"));
        System.out.println(Pattern.matches(reg, "http://domain.path.com?id=07701020028"));
    }

    @Test
    public void test3() {
        String reg = "^https?://([\\w-]+.)+[\\w-]+(/[\\w-./?&=]*)?$";
        System.out.println(Pattern.matches(reg, "https://domain.path.com?id=07701020028"));
        System.out.println(Pattern.matches(reg, "http://domain.path.com?id=07701020028"));

    }

    @Test
    public void test2() {
        String reg="(^\\d{2,4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+)";
        Pattern pattern = Pattern.compile(reg);
        String timeF = "25-01-22 15:07:50.449";
        Matcher matcher = pattern.matcher(timeF);
        System.out.println(matcher.find());
        System.out.println(Pattern.matches(reg, timeF));
        String timeS = "2025-01-22 15:07:50.449";
        Matcher matcher1 = pattern.matcher(timeS);
        System.out.println(matcher1.find());
        System.out.println(matcher1.matches());
        System.out.println(Pattern.matches(reg, timeS));
    }

    public Boolean solution(String ip) {
        if (Objects.isNull(ip)) {
            return false;
        }
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String sub : split) {
            if (sub.startsWith("0")) {
                return false;
            }
            try {
                int num = Integer.parseInt(sub);
                if (num > 255 || num < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void solutionTest() {
        Boolean solution = solution("192.168.3.1");
    }

}
