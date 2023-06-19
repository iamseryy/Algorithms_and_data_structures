package org.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list = new LinkedList<>();

        MyList<String> test = new MyLinkedList<>();
        test.addLast("10");
        test.addLast("20");
        test.addLast("30");
        test.addFirst("40");

        System.out.println(test);


        MyList<String> test2 = new MyLinkedList<>();
        System.out.println(test2);
    }
}
