package com.shpp.p2p.cs.adavydenko.assignment16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * This class creates objects for testing MyArrayList, MyLinkedList, MyStack
 * and MyQueue objects. Testing object are parametrized meaning that you can
 * set the start size of the object you create for testing. You are encouraged
 * to alter numbers 9, 9, 23 and 20 and to set your collections` sizes.
 * <p>
 * If I were you I would always keep three objects` tests launchers out of four
 * commented out so you can see console messages only for one of them at a time.
 * After you decided to switch to checking another object, comment out the current
 * object`s launcher, uncomment the next one and so on.
 * <p>
 * Following concepts were taken from external resources:
 * --- Generics
 * https://ru.stackoverflow.com/questions/264255/generic-%D0%B8-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D1%8B
 * --- LinkedList
 * https://javarush.ru/quests/lectures/questsyntaxpro.level13.lecture04
 * --- Iterator
 * http://blog.dreasgrech.com/2010/03/javas-iterators-and-iterables.html
 * http://mrbool.com/how-to-create-iterator-in-java/26422
 */
public class Assignment16Part1 {

    /**
     * Launches testing of four objects: MyArrayList, MyLinkedList,
     * MyStack and MyQueue.
     * All test objects are parametrized in order to create test array
     * of a certain size (9, 9, 23 and 20).
     *
     * @param args command line arguments are not provided.
     */
    public static void main(String[] args) {
        TestMyArrayList testArrayList = new TestMyArrayList(9);
        testArrayList.launchTest();

        TestMyLinkedList testLinkedList = new TestMyLinkedList(9);
        testLinkedList.launchTest();

        TestMyQueue testQueue = new TestMyQueue(20);
        testQueue.launchTest();

        TestMyStack testStack = new TestMyStack(23);
        testStack.launchTest();
    }
}
