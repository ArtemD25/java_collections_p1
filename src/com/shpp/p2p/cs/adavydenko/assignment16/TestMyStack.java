package com.shpp.p2p.cs.adavydenko.assignment16;

/**
 * This class test the functionality of the MyStack class by
 * calling various class` methods and printing the results of those
 * methods to console.
 */
public class TestMyStack {

    /**
     * Number of elements in the ARRAY that shall be created.
     */
    private final int NUM_OF_ELEMENTS_IN_ARRAY;

    /**
     * An array in form of the MyStack that is created in order
     * test the functionality of the MyStack class.
     */
    private final MyStack<String> STACK = new MyStack<>();

    /**
     * Sets the number of elements that the MyStack object shall consist of.
     * <p>
     * The minimal size was intentionally set to 5 in order to be able to
     * show all array`s methods working.
     *
     * @param numOfElementsInArray the number of elements that the MyStack
     *                             object shall consist of
     */
    public TestMyStack(int numOfElementsInArray) {
        if (numOfElementsInArray < 5) {
            this.NUM_OF_ELEMENTS_IN_ARRAY = 5;
        } else {
            this.NUM_OF_ELEMENTS_IN_ARRAY = numOfElementsInArray;
        }
    }

    /**
     * Launches all test for MyLinkedList object
     */
    public void launchTest() {
        System.out.println("------------------ LAUNCH MyStack TESTING");
        createAndDisplay();
        testPeek();
        testPop();
        testIsEmpty();
        testSeveralPushes();
        testSeveralPops();
        testIsFull();
        testForeach();
        System.out.println("\n------------------ END OF TEST");
    }

    /**
     * Creates an array and displays it to the console.
     */
    private void createAndDisplay() {
        System.out.println("---------------------------");
        System.out.println("Created stack, size: " + STACK.size());
        System.out.println("Now we fill the stack with items");
        for (int i = 0; i < NUM_OF_ELEMENTS_IN_ARRAY; i++) {
            STACK.push(i + "");
        }
        System.out.println("New stack size: " + STACK.size());
        STACK.printArray();
    }

    /**
     * Tests the stack`s peek() method.
     */
    private void testPeek() {
        System.out.println("---------------------------");
        System.out.println("Stack before peeking, size: " + STACK.size());
        STACK.printArray();
        System.out.println("Test peek() method. If we apply it to this stack we will get item: " + STACK.peek());
        System.out.println("Stack after peeking, size: " + STACK.size());
        STACK.printArray();
    }

    /**
     * Test the stack`s pop() method.
     */
    private void testPop() {
        System.out.println("---------------------------");
        System.out.println("Stack before popping, size: " + STACK.size());
        STACK.printArray();
        System.out.println("Test pop() method. If we apply it to this stack we will get: " + STACK.pop());
        System.out.println("Stack after popping, size: " + STACK.size());
        STACK.printArray();
    }

    /**
     * Tests stack`s isEmpty() method.
     */
    private void testIsEmpty() {
        System.out.println("---------------------------");
        System.out.println("Stack is empty: " + STACK.isEmpty());
        STACK.printArray();
        System.out.println("Now we remove all elements");
        while (STACK.size() != 0) {
            System.out.println("Removed object: " + STACK.pop());
            System.out.println("New stack size: " + STACK.size());
            STACK.printArray();
        }
        System.out.println("Stack is empty: " + STACK.isEmpty());
    }

    /**
     * Tests whether stack is full or not
     */
    private void testIsFull() {
        final int STACK_MAX_CAPACITY = 1000000;
        System.out.println("---------------------------");
        STACK.clear();
        System.out.println("Now we try to make the stack full");
        System.out.println("Stack size before: " + STACK.size());
        for (int i = STACK.size(); i < STACK_MAX_CAPACITY; i++) {
            STACK.push("A-" + i);
        }
        System.out.println("Stack size after: " + STACK.size());
        System.out.println("Stack is full: " + STACK.isFull());
        STACK.clear();
    }

    /**
     * Makes 37 pushes to the stack to check whether all elements are in right position.
     */
    private void testSeveralPushes() {
        System.out.println("---------------------------");
        System.out.println("Now we try to add several elements, than remove several elements and check whether everything went fine");
        System.out.println("First we clear the stack");
        while (STACK.size() != 0) {
            STACK.pop();
        }
        System.out.println("Stack is empty: " + STACK.isEmpty());
        System.out.println("Stack size: " + STACK.size());

        System.out.println("Now we fill stack with 37 elements and the top one shall be '36'");
        for (int i = 0; i < 37; i++) {
            STACK.push(i + "");
        }
        System.out.println("Stack size: " + STACK.size());
        System.out.println("Stack`s top element: " + STACK.peek());
        STACK.printArray();
    }

    /**
     * Makes 7 pops to the stack to check whether all elements are in right position.
     */
    private void testSeveralPops() {
        System.out.println("---------------------------");
        System.out.println("Stack size before we pop elements: " + STACK.size());
        STACK.printArray();
        System.out.println("Now we want to pop 5 elements. The top most element shall become '31'");
        for (int i = 0; i < 5; i++) {
            STACK.pop();
        }
        System.out.println("Stack`s top element: " + STACK.peek());
        STACK.printArray();
    }

    /**
     * Tests foreach iterator for stack.
     */
    private void testForeach() {
        System.out.println("---------------------------");
        System.out.println("We create following stack to test foreach: ");
        MyStack<Integer> arr = new MyStack<>();
        arr.push(1);
        arr.push(2);
        arr.push(null);
        arr.push(3);
        arr.push(4);
        arr.printArray();

        System.out.println("Now we iterate this stack using foreach");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
