package com.leet_code;

import static java.lang.System.out;

import com.leet_code.LC_706_Design_HashMap.MyHashMap.ListNode;

public class LC_706_Design_HashMap {
    public static void run() {
        MyHashMap obj = new MyHashMap();
//        obj.put(10000, 1);
//        obj.put(10000, 2);
//        obj.put(10000, 3);
//        obj.put(10, 4);
        obj.put(1, 5);
        obj.put(10001, 6);

        for (int i = 0; i < obj.nodes.length; i++) {
            if (obj.nodes[i] != null) {
                ListNode ln = obj.nodes[i];
                out.println("i:" + i + " val:" + ln.val + " key:" + ln.key);
                if (ln.next != null) {
                    ln = ln.next;
                    out.println("i:" + i + " val:" + ln.val + " key:" + ln.key);
                }
            }
        }

        out.println(obj.get(1));
        out.println(obj.get(10001));

        obj.remove(1);
        obj.remove(10001);

        out.println(obj.get(1));
        out.println(obj.get(10001));

//        out.println(obj.get(1));
//        obj.remove(1);
//        out.println(obj.get(1));
//
//        out.println(obj.get(10001));
//        out.println(obj.get(10000));

//        Arrays.stream(obj.nodes).forEach(listNode -> {
//            liste
//        });

//        int param_2 = obj.get(10000);
//        obj.remove(10000);
    }

    public static class MyHashMap {
        // Pair contains a key to value mapping
        // 10000 items only required
        public final ListNode[] nodes = new ListNode[10000];

        public MyHashMap() {
        }

        public void put(int key, int value) {
            int idx = idx(key);
            if (nodes[idx] == null) {
                nodes[idx] = new ListNode(key, value);
            } else {
                ListNode node = nodes[idx];
                ListNode nxt = node;
                if (nxt.key == key) {
                    nxt.val = value;
                } else {
                    while (nxt.next != null) {
                        nxt = nxt.next;
                        if (nxt.key == key) {
                            nxt.val = value;
                            return;
                        }
                    }
                    nxt.next = new ListNode(key, value);
                }
            }
        }

//        p    c
//        1 -> 2 -> 3 -> 4

        public int get(int key) {
            int idx = idx(key);
            ListNode node = nodes[idx];
            if (node == null) {return -1;}

            ListNode cur = node;
            while (cur != null) {
                if (cur.key == key) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        public void remove(int key) {
            final int idx = idx(key);
            final ListNode node = nodes[idx];
            if (node == null) {return;}
            ListNode sentinel = new ListNode(0, 0);
            sentinel.next = node;

            ListNode prev = sentinel, curr = node;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                }
                else {
                    prev = curr;
                }
                curr = curr.next;
            }
            nodes[idx] = sentinel.next;
        }

        int idx(int key) {
            return Integer.hashCode(key) % nodes.length;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
