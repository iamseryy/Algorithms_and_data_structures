package org.example;

public class MyLinkedList implements MyList{
    private Node head;
    private Node tail;


    @Override
    public void addLast(Object item) {

    }



    @Override
    public String toString() {
        var str = new StringBuilder();
        var node = this.head;
        str.append("["+ (node != null ? node.value.toString() : ""));
        node = node.next;

        while (node != null){
            str.append(", " + node.value.toString());
        }
        str.append("]");

        return str.toString();
    }



    private class Node <E> {
        E value;
        Node next;
    }
}
