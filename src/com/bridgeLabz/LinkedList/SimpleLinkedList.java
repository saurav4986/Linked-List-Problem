package com.bridgeLabz.LinkedList;
/*(UC2-Insertion_At_Start)
Ability to create LinkedList by adding 30 and 56 to 70
- Node with data 70 is First Created
- Next 30 is added to 70
- Finally 56 is added to 30
- LinkedList Sequence: 56->30->70*/
public class SimpleLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //append() is used to add node from last
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = new Node(data);
            return;
        }
        newNode.next=null;
        Node lastNode = head;// 10
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }
    //printList() to print the LinkedList
    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + "==>");
            tNode = tNode.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        //adding element before the head of the linked list
        //if linked list is empty then head will be null so will add the element in the head first
        if (head == null) {
            head = new Node(data);
            head.next = null;
            return;
        }
        Node newNode = new Node(data);
        //Changing the head reference to new node next reference
        newNode.next = head;
        //assigning the new Node reference to the head reference
        head = newNode;
    }

    public static void main(String[] args) {
        SimpleLinkedList ll = new SimpleLinkedList();
        ll.addFirst(70);
        ll.addFirst(30);
        ll.addFirst(56);
        ll.printList();

    }
}