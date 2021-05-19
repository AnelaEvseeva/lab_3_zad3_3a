package com.company;

import javax.xml.transform.SourceLocator;
import java.sql.SQLOutput;

class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" +next +
                "}";
    }
}

public class Main {
    public static Node createHead(int i) {
        Node head = null;
        for(; i >= 0; i--) {
            head = new Node(i, head);
        }
        return head;
    }

    public static Node createTail(int j) {
        Node head = new Node(0, null);
        Node tail = head;
        for (int i = 0; i < j; i++) {
            tail.next = new Node(i+1, null);
            tail = tail.next;
        }
        return tail;
    }

    public static Node addFirst(Node oldHead, Node node) {
        node.next = oldHead;
        return node;
    }

    public static  Node addLast(Node oldTail, Node newTail) {
        oldTail.next = newTail;
        return newTail;
    }

    public static Node Insert(Node head, Node newNode, int index){
        Node ref = head;
        int k = 1;
        while(ref.next != null && (k < index)) {
            ref = ref.next;
            k++;
        }
        newNode.next = ref.next;
        ref.next = newNode;
        return head;
    }

    public static Node Remove(Node head, int index){
        Node ref = head;
        int k = 1;
        while (ref.next != null && (k < index)) {
            ref = ref.next;
            k++;
        }
        return head;
    }

    public static Node removeFirst(Node head){
        return(head = head.next);
    }

    public static Node removeLast(Node head){
        Node ref = head;
        while(ref.next.next != null){
            ref = ref.next;
        }
        ref.next = null;

        return ref;
    }
    
    public static void main(String[] args) {
        int [] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Node head = createHead(4);
        System.out.println(head);
        Node newNode = new Node(-100, null);
        Node ref = Insert(head, newNode, 3);
        System.out.println(ref);
        System.out.println(removeFirst(head));
        head = removeLast(head);
        System.out.println(head);
        head = Remove(head, 2);
        System.out.println(head);

        Node tail = createTail(4);
        System.out.println(tail);

        Node newHead = addFirst(head, new Node(-1, null));
        System.out.println(newHead);

        Node newTail = addLast(tail, new Node(10, null));
        System.out.println(tail);
        System.out.println(newTail);

    }
}

