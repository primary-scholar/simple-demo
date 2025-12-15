package com.mimu.simple.java.cm;

import org.junit.Test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * author: mimu
 * date: 2019/9/10
 */
public class ChineseOrderTest {
    private static Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");

    public List<String> getList() {
        List<String> name = new ArrayList<>();
        name.add("好二");
        name.add("haiming");
        name.add("haoming");
        name.add("号字");
        name.add("韩$杨");
        name.add("翔子");
        name.add("安明");
        name.add("褚健");
        name.add(" he");
        return name;
    }

    @Test
    public void order() {
        List<String> name = getList();
        Collator collator = Collator.getInstance(Locale.CHINA);
        name = name.stream().sorted(collator::compare).collect(Collectors.toList());
        System.out.println(name);
    }

}
