package org.example;

public class MyLinkedList <E>  implements MyList {
    private Node head;
    private Node tail;


    @Override
    public void addLast(Object item) {
        var node = new Node<E>();
        node.value = (E) item;
        if(tail == null){
            head = node;
        }else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    @Override
    public void addFirst(Object item) {
        var node = new Node<E>();
        node.value = (E) item;
        if(head == null){
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    @Override
    public String toString() {
        var node = this.head;
        if (node == null){
            return "[]";
        }

        var str = new StringBuilder();
        str.append("[" + (node != null ? node.value.toString() : ""));
        node = node.next;

        while (node != null){
            str.append(", " + node.value.toString());
            node = node.next;
        }
        str.append("]");

        return str.toString();
    }

    private static class Node <E> {
        E value;
        Node next;
        Node prev;
    }
}
