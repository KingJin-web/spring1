package com.king.spring1.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: spring1
 * @description:
 * @author: King
 * @create: 2021-08-12 16:14
 */
public class Main {
    public List<String> split(String txt) {
        HashSet<String> set = new HashSet<String>();

        while (txt.contains(",")) {
            int index = txt.indexOf(",");
            String tmp = txt.substring(0, index).trim();
            set.add(tmp);
            txt = txt.substring(index + 1);
        }
        set.add(txt);
        return new ArrayList<String>(set);

    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.split("aa,aa,vvv,www,www ,dd dd"));

    }
}
