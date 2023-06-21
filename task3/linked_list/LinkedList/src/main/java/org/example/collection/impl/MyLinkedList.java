package org.example.collection.impl;

import org.example.collection.MyList;

import java.util.Comparator;
import java.util.Optional;

public class MyLinkedList<E>  implements MyList<E> {
    private Node head;
    private Node tail;


    @Override
    public void addLast(E item) {
        var node = new Node<E>();
        node.value = item;
        if(this.tail == null){
            this.head = node;
        }else{
            node.prev = this.tail;
            this.tail.next = node;
        }
        this.tail = node;
    }

    @Override
    public void addFirst(E item) {
        var node = new Node<E>();
        node.value = item;
        if(this.head == null){
            this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
        }
        this.head = node;
    }

    @Override
    public void reverse() {
        var node = this.head;
        while (node != null){
            Node prev = node.prev;
            node.prev = node.next;
            node.next = prev;
            node = node.prev;
        }

        if (head != null){
            node = this.head;
            this.head = this.tail;
            this.tail = node;
        }
    }

    @Override
    public Optional<E> removeFirst() {
        if (this.head == null){
            return Optional.empty();
        }

        final var node = this.head;
        this.head = this.head.next;
        return (Optional<E>) Optional.ofNullable(node.value);
    }

    @Override
    public Optional<E> removeLast() {
        if (this.tail == null){
            return Optional.empty();
        }

        final var node = this.tail;
        this.tail = this.tail.prev;
        return (Optional<E>) Optional.ofNullable(node.value);
    }

    @Override
    public int indexOf(Object item) {
        int index = 0;
        var node = this.head;

        if (item == null) {
            while (node != null){
                if (node.value == null){
                    return index;
                }
                node = node.next;
                index++;
            }
        } else{
            while (node != null){
                if (((E) item).equals(node.value)){
                    return index;
                }
                node = node.next;
                index++;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
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
