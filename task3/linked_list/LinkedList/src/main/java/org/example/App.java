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

        System.out.println(people.removeFirst().get());
        System.out.println(people);


        MyList<String> items = new MyLinkedList<>();
        items.addFirst(null);
        items.addFirst("20");
        items.addFirst("30");

        System.out.println(items.indexOf(null));

        LinkedList<Integer> test = new LinkedList<>();
test.sort();

    }
}
