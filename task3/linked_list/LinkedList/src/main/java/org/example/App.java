package org.example;


import org.example.collection.impl.MyLinkedList;
import org.example.collection.MyList;
import org.example.model.Person;

import java.util.LinkedList;

public class App
{
    public static void main( String[] args )
    {
        MyList<Person> people = new MyLinkedList<>();

        people.addLast(new Person("Ivan", 33, 180.5));
        people.addLast(new Person("Maxim", 44, 175.5));
        people.addFirst(new Person("Olga", 30, 170.5));

        System.out.println(people);

        people.reverse();

        System.out.println(people);

    }
}
