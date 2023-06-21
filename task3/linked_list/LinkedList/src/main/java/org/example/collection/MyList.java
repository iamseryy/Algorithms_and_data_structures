package org.example.collection;

import java.util.Comparator;
import java.util.Optional;

public interface MyList <E>{
    void addLast(E item);
    void addFirst(E item);
    void reverse();
    Optional<E> removeFirst();
    Optional<E> removeLast();
    int indexOf(E item);
    boolean contains(E item);
}
