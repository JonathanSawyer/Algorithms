package com.leet_code;

import java.util.HashMap;
import java.util.Map.Entry;

public class LC_5382_HTML_Entity_Parser {
    public static void run() {
        System.out.println(entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }

    public static String entityParser(String text) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for (Entry<String, String> e : map.entrySet()) {
            text = text.replaceAll(e.getKey(), e.getValue());
        }
        return text;
    }
}
