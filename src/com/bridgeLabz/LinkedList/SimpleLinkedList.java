package com.bridgeLabz.LinkedList;
/*(UC9-Size)
Ability to delete 40 from the Linked List sequence of 56->30->40->70 and show the size of LinkedList is 3
- Search LinkedList to find node with key value 40
- Delete the node
- Implement size() and show the Linked List size is 3
- Final Sequence: 56->30->70*/
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
    //insertAtIndex(int index, int data) insert element between two given element
    public void insertAtIndex(int index, int data) {
        Node node = new Node(data);
        node.data = data;
        node.next = null;
        if (head == null) {
            addFirst(data);
        } else {
            Node temp;
            temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    //pop() is used to delete from first i.e. head
    public void pop(){
        if (head == null){
            System.out.println("list is empty");
            return;
        }
        head = head.next;
    }

    //popLast() used to delete last element in the list
    public void popLast(){
        if (head == null){
            System.out.println("list is empty");
            return;
        }
        if (head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    //searchNodeWithKey(int data) to search provided elements exists in the list or not
    public void searchNodeWithKey(int data) {
        Node searchNode = new Node(data);
        searchNode.data = data;
        searchNode.next = null;
        if (head == null) {
            System.out.println("Linked list empty!!");
        } else {
            Node temp;
            temp = head;
            while (temp != null) {
                if (temp.data == searchNode.data) {
                    System.out.println("Node Found ==>" + searchNode.data);
                    break;
                } else {
                    temp = temp.next;
                }
            }
            if (temp == null)
                System.out.println("!!!Node not found!!!");
        }
    }
    //deleteNode(int index) used to delete node from particular index
    public void deleteNode(int index) {
        Node node;
        Node temp;
        temp = head;
        if (head == null) {
            System.out.println("Linked list empty!!");
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            if (index == 0) {
                head = head.next;
                temp = null;
            } else {
                node = temp.next;
                temp.next = node.next;
                node = null;
            }
        }
    }

    //sizeOfLinkedList() used to find the size of the list
    public void sizeOfLinkedList() {
        Node temp;
        temp = head;
        int count = 0;
        if (head == null) {
            System.out.println("Linked list empty!!");
        } else {
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
            count++;
            System.out.println("Size of Linked list is " + count);
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList ll = new SimpleLinkedList();
        ll.addFirst(70);
        ll.addFirst(30);
        ll.addFirst(56);
        //System.out.println("Elements before:");
        ll.printList();
        ll.searchNodeWithKey(30);
        //System.out.println("Elements after:");
        ll.insertAtIndex(2,40);
        ll.printList();
        ll.searchNodeWithKey(40);
        ll.deleteNode(2);
        ll.printList();
        ll.sizeOfLinkedList();

    }
}