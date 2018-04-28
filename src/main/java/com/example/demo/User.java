package com.example.demo;

import java.util.*;


public class User {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedList<ListNode> queue = new LinkedList<>();
        LinkedList<ListNode> queue2 = new LinkedList<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null) {
            queue.addLast(temp1);
            temp1 = temp1.next;
        }


        while (temp2 != null) {
            queue2.addLast(temp2);
            temp2 = temp2.next;
        }

        ListNode[] nodes = new ListNode[queue.size() + queue2.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            nodes[index++] = queue.pollFirst();
        }
        while (!queue2.isEmpty()) {
            nodes[index++] = queue2.pollFirst();
        }
        Arrays.sort(nodes, Comparator.comparing(node -> node.val));

        ListNode node = nodes[0];
        ListNode res = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            node.next = nodes[i];
            node = node.next;
        }
        node.next = null;
        return res;


    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList<ListNode> nodes = new LinkedList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        Collections.sort(nodes, Comparator.comparing(node -> -node.val));

        ListNode res = nodes.pollFirst();
        ListNode temp = res;
        while (!nodes.isEmpty()) {
            res.next = nodes.pollFirst();
            res = res.next;
        }
        res.next = null;


        return temp;
    }

    public int getN(int i) {
        if (i == 1) {
            return 1;
        }
        return i * getN(i - 1);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String str = String.valueOf(x);
        if (x < 0) {
            str = str.substring(1, str.length());
        }
        char[] array = str.toCharArray();
        String xx = "";
        for (int begin = 0, last = array.length - 1; begin < array.length / 2; begin++, last--) {
            char temp = array[begin];
            array[begin] = array[last];
            array[last] = temp;


        }
        boolean flag = false;
        for (char c : array) {
            if (!flag && c == 0) {
                continue;
            }
            flag = true;
            xx += c;
        }

        try{
            Integer.valueOf(xx);
        }catch (Exception e){
            return 0;
        }

        return x < 0 ? -Integer.valueOf(xx) : Integer.valueOf(xx);

    }

    public static void main(String[] args) {


        System.out.println(new User().reverse(1534236469));


    }

}
