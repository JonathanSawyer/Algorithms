package com.company;

import java.util.ArrayList;
import java.util.List;

public class test_change_position {
    public static class a {
        public int order;
        public String name;
    }

    public static void run() {
        a a1 = new a();
        a1.name = "a1";
        a1.order = 1;
        a a2 = new a();
        a2.name = "a1";
        a2.order = 2;
        a a3 = new a();
        a3.name = "a1";
        a3.order = 3;
        a a4 = new a();
        a4.name = "a1";
        a4.order = 4;
        a a5 = new a();
        a5.name = "a1";
        a5.order = 5;

        List<a> aaa = new ArrayList();
        aaa.add(a1);
        aaa.add(a2);
        aaa.add(a3);
        aaa.add(a4);
        aaa.add(a5);

        // get the index
        // splice the value
        //
    }
}
