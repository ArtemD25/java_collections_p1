package com.shpp.p2p.cs.adavydenko.assignment16;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a copy of a Stack class with
 * only several most used methods provided.
 *
 * @param <T> stands for a type of the elements that will be stored in the array
 */
public class MyStack<T> implements Iterable<T> {

    /**
     * The first node of the stack.
     */
    private final Node<T> FIRST_NODE;

    /**
     * The last node of the stack.
     */
    private final Node<T> LAST_NODE = new Node<>(false, null, null);

    /**
     * Number of object already added to the stack
     */
    private int numOfAddedObjects = 0;

    /**
     * The default maximum size for the stack.
     */
    private final int STACK_MAX_SIZE = 1000000;

    /**
     * Constructor for creating a MyStack object. When created the
     * MyStack has only two nodes - the first and the last one.
     * Those nodes do not contain any meaningful information a user
     * wants to store. They are created to mark the MyStack`s
     * start and the end.
     */
    public MyStack() {
        this.FIRST_NODE = new Node<>(true, this.LAST_NODE, null);
        //this.LAST_NODE = new Node<>(false, null, this.FIRST_NODE);
        this.LAST_NODE.setPrevNode(FIRST_NODE);
    }

    /**
     * Returns the number of objects added to the stack.
     *
     * @return the number of objects added to the stack.
     */
    public int size() {
        return numOfAddedObjects;
    }

    /**
     * Adds an object to the start of the stack
     *
     * @param obj is an object provided by user to be added to the stack.
     * @return the value of the object that was added to the stack.
     */
    public T push(T obj) {
        if (numOfAddedObjects + 1 <= STACK_MAX_SIZE) {
            Node<T> newNode = new Node<>(obj, FIRST_NODE.getNextNode(), FIRST_NODE);
            FIRST_NODE.getNextNode().setPrevNode(newNode);
            FIRST_NODE.setNextNode(newNode);
            numOfAddedObjects++;
            return obj;
        } else {
            throw new StackOverflowError();
        }
    }

    /**
     * Removes the very first element from the stack.
     *
     * @return the value of the object that was removed from the stack.
     */
    public T pop() {
        if (numOfAddedObjects > 0) {
            Node<T> currentNode = FIRST_NODE.getNextNode(); // the node to be removed
            FIRST_NODE.setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setPrevNode(FIRST_NODE);
            numOfAddedObjects--;
            return currentNode.getValue();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Gets the value of the top most element of the stack without
     * removing this element from the stack.
     *
     * @return the value of the stack`s top element.
     */
    public T peek() {
        if (numOfAddedObjects > 0) {
            return FIRST_NODE.getNextNode().getValue();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes all objects from the stack.
     */
    public void clear() {
        if (numOfAddedObjects > 0) {
            FIRST_NODE.setNextNode(LAST_NODE);
            LAST_NODE.setPrevNode(FIRST_NODE);
            numOfAddedObjects = 0;
        }
    }

    /**
     * Says whether the stack is empty or not.
     *
     * @return true if the stack is empty.
     */
    public boolean isEmpty() {
        return numOfAddedObjects <= 0;
    }

    /**
     * Says whether the stack is full.
     * It is deemed to be full when the number of elements
     * inside the stack is equal to the default stack size.
     *
     * @return true if the stack is full.
     */
    public boolean isFull() {
        return numOfAddedObjects == STACK_MAX_SIZE;
    }

    /**
     * Prints the MyStack to console with all its items being
     * displayed in one line and separated by a comma. All the array`s
     * data is surrounded by square brackets.
     */
    public void printArray() {
        Node<T> currentNode = FIRST_NODE.getNextNode();

        if (!currentNode.IS_LAST) { // If the next node of the first node is not the last node
            System.out.print("\n[");
            while (!currentNode.IS_LAST) { // While we do not get to the last node of the Stack

                if (currentNode.getNextNode().IS_LAST) {
                    System.out.print(currentNode.getValue());
                } else {
                    System.out.print(currentNode.getValue() + ", ");
                }
                currentNode = currentNode.getNextNode();
            }
            System.out.print("]\n");
        } else {
            System.out.println("[]\n");
        }
    }

    /**
     * Creates a copy of a current MyStack object.
     */
    private MyStack<T> copyCollection(MyStack<T> stack) {
        MyStack<T> newStack = new MyStack<>();
        Node<T> currentNode = stack.LAST_NODE.getPrevNode();
        while (!currentNode.IS_FIRST) {
            newStack.push(currentNode.getValue());
            currentNode = currentNode.getPrevNode();
        }
        return newStack;
    }

    /**
     * Creates and returns a MyIterator object to enable
     * the MyStack object to use foreach loop.
     *
     * @return a MyIterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator(this);
    }

    /**
     * This class has description of three methods used to
     * created an iterator instance to enable the MyStack
     * object to use foreach loop
     */
    private class MyIterator implements Iterator<T> {

        /**
         * A link to a particular MyStack object whose
         * elements shall be iterated.
         */
        private final MyStack<T> LIST;

        /**
         * Copies a link of a MyStack object to access the
         * elements that shall be iterated and sets the index
         * to begin with to zero.
         *
         * @param stack is a MyStack object whose elements shall
         *              be provided to iterator.
         */
        private MyIterator(MyStack<T> stack) {
            LIST = copyCollection(stack);
        }

        /**
         * Says whether there is any element left in the MyStack
         * object that can be extracted and processed in a foreach loop.
         *
         * @return true if there is such element.
         */
        @Override
        public boolean hasNext() {
            return LIST.size() > 0;
        }

        /**
         * Provides the next element to process it
         * in the foreach loop.
         *
         * @return the next element of the MyStack object.
         */
        @Override
        public T next() {
            return LIST.pop();
        }
    }
}
