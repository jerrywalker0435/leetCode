package com.leetcode.bytedance.list;

import org.junit.Test;

public class ReverseList {

    /*
     反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

    @Test
    public void solution(){
        Node list = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        System.out.println(reverseList(list));
    }
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }
    Node(int x,Node next) {
        val = x;
        this.next = next;
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}