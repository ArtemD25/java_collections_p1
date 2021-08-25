package com.shpp.p2p.cs.adavydenko.assignment16;

/**
 * This class test the functionality of the MyQueue class by
 * calling various class` methods and printing the results of those
 * methods to console.
 */
public class TestMyQueue {

    /**
     * Number of elements in the ARRAY that shall be created.
     */
    private final int NUM_OF_ELEMENTS_IN_ARRAY;

    /**
     * An array in form of the MyQueue that is created in order
     * test the functionality of the MyQueue class.
     */
    private final MyQueue<Integer> QUEUE = new MyQueue<>();

    /**
     * Sets the number of elements that the MyQueue object shall consist of.
     * <p>
     * The minimal size was intentionally set to 5 in order to be able to
     * show all array`s methods working.
     *
     * @param numOfElementsInArray the number of elements that the MyQueue
     *                             object shall consist of
     */
    public TestMyQueue(int numOfElementsInArray) {
        if (numOfElementsInArray < 5) {
            this.NUM_OF_ELEMENTS_IN_ARRAY = 5;
        } else {
            this.NUM_OF_ELEMENTS_IN_ARRAY = numOfElementsInArray;
        }
    }

    /**
     * Launches all test for MyQueue object
     */
    protected void launchTest() {
        System.out.println("------------------ LAUNCH MyQueue TESTING");
        fillQueueAndDisplay();
        removeElements();
        testGettingElements();
        testMultipleAddings();
        fillQueueToMax();
        testForeach();
        System.out.println("\n------------------ END OF TEST");
    }

    /**
     * Fills the queue and displays it to the console.
     */
    private void fillQueueAndDisplay() {
        System.out.println("---------------------------");
        System.out.println("First we create a queue with size " + NUM_OF_ELEMENTS_IN_ARRAY);
        for (int i = 0; i < NUM_OF_ELEMENTS_IN_ARRAY; i++) {
            QUEUE.addLast(i);
        }
        System.out.println("Queue size: " + QUEUE.size());
        QUEUE.printArray();
    }

    /**
     * Test how the queue removes almost all elements.
     */
    private void removeElements() {
        System.out.println("---------------------------");
        System.out.println("Now we remove all elements except for the last one");
        int size = QUEUE.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.println("Removed: " + QUEUE.removeFirst());

        }
        System.out.println("The queue`s new size is " + QUEUE.size());
        QUEUE.printArray();
    }

    /**
     * Test whether the queue does not remove the first element after
     * getting it.
     */
    private void testGettingElements() {
        System.out.println("---------------------------");
        System.out.println("Now we create a queue from scratch with size 10");
        QUEUE.clear();
        for (int i = 0; i < 10; i++) {
            QUEUE.addLast(i);
        }
        System.out.println("Size " + QUEUE.size());
        QUEUE.printArray();
        System.out.println("Now we get the first element and it shall remain in the queue");
        System.out.println("First element " + QUEUE.getFirst());
        System.out.println("Size " + QUEUE.size());
        QUEUE.printArray();
    }

    /**
     * Test whether the queue adds and removes many items correctly.
     */
    private void testMultipleAddings() {
        System.out.println("---------------------------");
        System.out.println("Now we create a queue from scratch again");
        QUEUE.clear();
        QUEUE.printArray();
        System.out.println("And fill it with 97 elements, than subtract 73 and add 7. The size shall be 97 - 73 + 7 = "
                + (97 - 73 + 7));
        for (int i = 0; i < 97; i++) {
            QUEUE.addLast(i);
        }
        for (int i = 0; i < 73; i++) {
            QUEUE.removeFirst();
        }
        for (int i = 0; i < 7; i++) {
            QUEUE.addLast(i);
        }
        System.out.println("Size shall be " + (97 - 73 + 7));
        System.out.println("Size " + QUEUE.size());
        QUEUE.printArray();
    }

    /**
     * Tries to fill the queue to its maximum capacity
     */
    private void fillQueueToMax() {
        final int QUEUE_MAX_CAPACITY = 1000000;
        System.out.println("---------------------------");
        QUEUE.clear();
        System.out.println("What happens if we fill the queue to the maximum?");
        for (int i = 0; i < QUEUE_MAX_CAPACITY; i++) {
            QUEUE.addLast(i);
        }
        System.out.println("Size " + QUEUE.size());
        System.out.println("Queue is full: " + QUEUE.isFull());
        QUEUE.clear();
    }

    /**
     * Tests foreach iterator for queue.
     */
    private void testForeach() {
        System.out.println("---------------------------");
        System.out.println("We create following queue to test foreach: ");
        MyQueue<Integer> arr = new MyQueue<>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(null);
        arr.addLast(3);
        arr.addLast(4);
        arr.printArray();

        System.out.println("Now we iterate this queue using foreach");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
