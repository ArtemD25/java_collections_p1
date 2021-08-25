package com.shpp.p2p.cs.adavydenko.assignment16;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a copy of a Queue (ArrayDeque) with
 * only several most used methods provided.
 *
 * @param <T> stands for a type of the elements that will be stored in the array
 */
public class MyQueue<T> implements Iterable<T> {

    /**
     * The first node of a queue.
     */
    private final Node<T> FIRST_NODE;

    /**
     * The last node of a queue.
     */
    private final Node<T> LAST_NODE = new Node<>(false, null, null);

    /**
     * Number of object already added to the queue
     */
    private int numOfAddedObjects = 0;

    /**
     * The default maximum size for the queue.
     */
    private final int QUEUE_MAX_SIZE = 1000000;

    /**
     * Constructor for creating a MyQueue object. When created the
     * MyQueue has only two nodes - the first and the last one.
     * Those nodes do not contain any meaningful information a user
     * wants to store. They are created to mark the MyQueue`s
     * start and the end.
     */
    public MyQueue() {
        this.FIRST_NODE = new Node<>(true, LAST_NODE, null);
        this.LAST_NODE.setPrevNode(FIRST_NODE);
    }

    /**
     * Returns the number of objects added to the queue.
     *
     * @return the number of objects added to the queue.
     */
    public int size() {
        return numOfAddedObjects;
    }

    /**
     * Adds an object to the end of the queue
     *
     * @param obj is an object provided by user to be
     *            added to the queue.
     */
    public void addLast(T obj) {
        if (numOfAddedObjects + 1 <= QUEUE_MAX_SIZE) {
            Node<T> newNode = new Node<>(obj, LAST_NODE, LAST_NODE.getPrevNode());
            // Setting the new node as the new nextNode for the previous prevNode of the LAST_NODE
            LAST_NODE.getPrevNode().setNextNode(newNode);
            // Setting the new node as the new prevNode for the LAST_NODE
            LAST_NODE.setPrevNode(newNode);
            numOfAddedObjects++;
        } else {
            throw new IllegalStateException("Queue is too big");
        }

    }

    /**
     * Removes the very first element from the queue.
     *
     * @return the element that was removed.
     */
    public T removeFirst() {
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
     * Gets the value of the top most element of the queue without
     * removing this element from the queue.
     *
     * @return the value of the queue`s top element.
     */
    public T getFirst() {
        if (numOfAddedObjects > 0) {
            return FIRST_NODE.getNextNode().getValue();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes all objects from the queue.
     */
    public void clear() {
        if (numOfAddedObjects > 0) {
            FIRST_NODE.setNextNode(LAST_NODE);
            LAST_NODE.setPrevNode(FIRST_NODE);
            numOfAddedObjects = 0;
        }
    }

    /**
     * Says whether the queue is empty or not.
     *
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        return numOfAddedObjects <= 0;
    }

    /**
     * Says whether the queue is full.
     * It is deemed to be full when the number of elements
     * inside the queue is equal to the default queue size.
     *
     * @return true if the queue is full.
     */
    public boolean isFull() {
        return numOfAddedObjects == QUEUE_MAX_SIZE;
    }

    /**
     * Prints the MyQueue to console with all its items being
     * displayed in one line and separated by a comma. All the array`s
     * data is surrounded by square brackets.
     */
    public void printArray() {
        Node<T> currentNode = FIRST_NODE.getNextNode();

        if (!currentNode.IS_LAST) { // If the next node of the first node is not the last node
            System.out.print("\n[");
            while (!currentNode.IS_LAST) { // While we do not get to the last node of the queue

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
     * Creates a copy of a current MyQueue object.
     */
    private MyQueue<T> copyCollection(MyQueue<T> queue) {
        MyQueue<T> newQueue = new MyQueue<>();
        Node<T> currentNode = queue.FIRST_NODE.getNextNode();
        while (!currentNode.IS_LAST) {
            newQueue.addLast(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
        return newQueue;
    }

    /**
     * Creates and returns a MyIterator object to enable
     * the MyQueue object to use foreach loop.
     *
     * @return a MyIterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator(this);
    }

    /**
     * This class has description of three methods used to
     * created an iterator instance to enable the MyQueue
     * object to use foreach loop
     */
    private class MyIterator implements Iterator<T> {

        /**
         * A link to a particular MyQueue object whose
         * elements shall be iterated.
         */
        private final MyQueue<T> LIST;

        /**
         * Copies a link of a MyQueue object to access the
         * elements that shall be iterated and sets the index
         * to begin with to zero.
         *
         * @param queue is a MyQueue object whose elements shall
         *              be provided to iterator.
         */
        private MyIterator(MyQueue<T> queue) {
            LIST = copyCollection(queue);
        }

        /**
         * Says whether there is any element left in the MyQueue
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
         * @return the next element of the MyQueue object.
         */
        @Override
        public T next() {
            return LIST.removeFirst();
        }
    }
}
