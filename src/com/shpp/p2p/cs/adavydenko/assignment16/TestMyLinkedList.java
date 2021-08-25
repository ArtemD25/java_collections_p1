package com.shpp.p2p.cs.adavydenko.assignment16;

/**
 * This class test the functionality of the MyLinkedList class by
 * calling various class` methods and printing the results of those
 * methods to console.
 */
public class TestMyLinkedList {

    /**
     * Number of elements in the ARRAY that shall be created.
     */
    private final int NUM_OF_ELEMENTS_IN_ARRAY;

    /**
     * An array in form of the MyLinkedList that is created in order
     * test the functionality of the MyLinkedList class.
     */
    private final MyLinkedList<String> ARRAY = new MyLinkedList<>();

    /**
     * Sets the number of elements that the MyLinkedList object shall consist of.
     * <p>
     * The minimal size was intentionally set to 5 in order to be able to
     * show all array`s methods working.
     *
     * @param numOfElementsInArray the number of elements that the MyLinkedList
     *                             object shall consist of
     */
    public TestMyLinkedList(int numOfElementsInArray) {
        if (numOfElementsInArray < 5) {
            this.NUM_OF_ELEMENTS_IN_ARRAY = 5;
        } else {
            this.NUM_OF_ELEMENTS_IN_ARRAY = numOfElementsInArray;
        }
    }

    /**
     * Launches all test for MyLinkedList object
     */
    protected void launchTest() {
        System.out.println("------------------ LAUNCH MyLinkedList TESTING");
        createAndDisplay();
        substituteElement();
        printSeparateArrayItems();
        addElementInTheRear();
        addElementInTheMiddle();
        getIndexOfElement();
        testContainsMethod();
        removeElements();
        testArrayClear();
        testAdditionalMethods();
        testForeach();
        testContainsNull();
        System.out.println("\n------------------ END OF TEST");
    }

    /**
     * Creates an array and displays it to the console.
     */
    private void createAndDisplay() {
        System.out.println("---------------------------");
        System.out.println("First we create and display the MyLinkedList object");
        for (int i = 0; i < NUM_OF_ELEMENTS_IN_ARRAY; i++) {
            ARRAY.add("A-" + i);
        }
        System.out.println("Array created, size: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Substitutes one element in the array by the other one
     */
    private void substituteElement() {
        System.out.println("---------------------------");
        final int SUBSTITUTE_INDEX;
        if (NUM_OF_ELEMENTS_IN_ARRAY - 2 < 0) {
            SUBSTITUTE_INDEX = 0;
        } else {
            SUBSTITUTE_INDEX = NUM_OF_ELEMENTS_IN_ARRAY - 2;
        }
        System.out.println("Substituting element with index " + SUBSTITUTE_INDEX + " to element 'Hello'");
        ARRAY.set(SUBSTITUTE_INDEX, "Hello");
        System.out.println("Array changed, size: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Prints to console both not-existing element and an existing element
     */
    private void printSeparateArrayItems() {
        System.out.println("---------------------------");
        final int PRINT_INDEX;
        if (NUM_OF_ELEMENTS_IN_ARRAY - 1 < 0) {
            PRINT_INDEX = 0;
        } else {
            PRINT_INDEX = NUM_OF_ELEMENTS_IN_ARRAY - 1;
        }
        System.out.println("Printing to console the element with index " + PRINT_INDEX);
        System.out.println("Element with i = " + PRINT_INDEX + ": " + ARRAY.get(PRINT_INDEX));
        ARRAY.printArray();
    }

    /**
     * Adds new element in the rear of the array
     */
    private void addElementInTheRear() {
        System.out.println("---------------------------");
        System.out.println("Adding new element in the end: World");
        ARRAY.add("World");
        System.out.println("Array changed, size: " + ARRAY.size());
        ARRAY.printArray();
        System.out.println("Adding new element in the end: Kyiv");
        ARRAY.add("Kyiv");
        System.out.println("Array changed, size: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Adds new element in the middle of the array
     */
    private void addElementInTheMiddle() {
        System.out.println("---------------------------");
        final int ADDING_INDEX;
        if (ARRAY.size() < 1) {
            ADDING_INDEX = 0;
        } else {
            ADDING_INDEX = (int) Math.floor(NUM_OF_ELEMENTS_IN_ARRAY / 2.0);
        }
        System.out.println("Adding new element (Berlin) in the middle to position " + ADDING_INDEX);
        ARRAY.add(ADDING_INDEX, "Berlin");
        System.out.println("Array changed, size: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Prints to console the index of the requested element/
     */
    private void getIndexOfElement() {
        System.out.println("---------------------------");
        final int ADDING_INDEX;
        if (ARRAY.size() < 1) {
            ADDING_INDEX = 0;
        } else {
            ADDING_INDEX = (int) Math.floor(NUM_OF_ELEMENTS_IN_ARRAY - 1 / 2.0);
        }
        System.out.println("Getting the index of the newly created element - Berlin");
        System.out.println("The index of Berlin is " + ARRAY.indexOf("Berlin"));
        ARRAY.printArray();
    }

    /**
     * Test "contains" method by calling it on four elements.
     */
    private void testContainsMethod() {
        System.out.println("---------------------------");
        System.out.println("Testing whether the ARRAY contains following elements");
        System.out.println("Contains 'World'? - " + ARRAY.contains("World"));
        System.out.println("Contains 'Earth'? - " + ARRAY.contains("Earth"));
        System.out.println("Contains 'Kyiv'? - " + ARRAY.contains("Kyiv"));
        System.out.println("Contains 'A-10'? - " + ARRAY.contains("A-10"));
        ARRAY.printArray();
    }

    /**
     * Removes elements from array by index and by their values.
     */
    private void removeElements() {
        System.out.println("---------------------------");
        System.out.println("Now we remove element 'World'");
        System.out.println("Array size before removing: " + ARRAY.size());
        ARRAY.remove("World");
        System.out.println("Array size after removing: " + ARRAY.size());
        System.out.println("Contains 'World'? - " + ARRAY.contains("World"));
        ARRAY.printArray();

        System.out.println("---------------------------");
        System.out.println("We can remove element 'Berlin' as well");
        System.out.println("Array size before removing: " + ARRAY.size());
        ARRAY.remove("Berlin");
        System.out.println("Array size after removing: " + ARRAY.size());
        System.out.println("Contains 'Berlin'? - " + ARRAY.contains("Berlin"));
        ARRAY.printArray();

        System.out.println("---------------------------");
        System.out.println("Now we remove an element with index '1'");
        System.out.println("Array size before removing: " + ARRAY.size());
        if (ARRAY.size() >= 1) {
            ARRAY.remove(1);
        } else {
            System.out.println("Sorry, the ARRAY has no elements");
        }
        System.out.println("Array size after removing: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Test clearing of array - removes all elements from it
     */
    private void testArrayClear() {
        System.out.println("---------------------------");
        System.out.println("Now it is time to clear the ARRAY");
        System.out.println("Array size before clearing: " + ARRAY.size());
        ARRAY.printArray();
        ARRAY.clear();
        System.out.println("\nArray size after clearing: " + ARRAY.size());
        ARRAY.printArray();
    }

    /**
     * Test additional methods the the LinkedList has and the ArrayList does not
     */
    private void testAdditionalMethods() {
        System.out.println("---------------------------");
        System.out.println("Now we test:\n-addFirst()\n-addLast()\n-removeFirst()\n-removeLast()\n-getFirst()\n-getLast()");
        testAddFirst();
        testAddLast();
        testGetFirst();
        testGetLast();
        testRemoveFirst();
        testRemoveLast();
    }

    /**
     * Adds an element to the head of the array
     */
    private void testAddFirst() {
        System.out.println("---------------------------");
        System.out.println("Adding three numbers from 1 to 3 to the beginning of the array");
        ARRAY.clear();
        ARRAY.addFirst("1");
        ARRAY.printArray();
        ARRAY.addFirst("2");
        ARRAY.printArray();
        ARRAY.addFirst("3");
        ARRAY.printArray();
    }

    /**
     * Adds an element to the rear of the array
     */
    private void testAddLast() {
        System.out.println("---------------------------");
        System.out.println("Adding three numbers from 98 to 100 to the end of the array");
        ARRAY.addLast("98");
        ARRAY.printArray();
        ARRAY.addLast("99");
        ARRAY.printArray();
        ARRAY.addLast("100");
        ARRAY.printArray();
    }

    /**
     * Provides the first element of the array without deleting it
     */
    private void testGetFirst() {
        System.out.println("---------------------------");
        System.out.println("Now we want to see which element is the first element of the array");
        System.out.println("The first element: " + ARRAY.getFirst());
        ARRAY.printArray();
    }

    /**
     * Provides the last element of the array without deleting it
     */
    private void testGetLast() {
        System.out.println("---------------------------");
        System.out.println("Now we want to see which element is the last element of the array");
        System.out.println("The last element: " + ARRAY.getLast());
        ARRAY.printArray();
    }

    /**
     * Provides the first element of the array and deletes it
     */
    private void testRemoveFirst() {
        System.out.println("---------------------------");
        System.out.println("Now we remove the first element of the array");
        System.out.println("Array before removing:");
        ARRAY.printArray();
        System.out.println("We removed: " + ARRAY.removeFirst());
        System.out.println("Array after removing:");
        ARRAY.printArray();
    }

    /**
     * Provides the last element of the array and deletes it
     */
    private void testRemoveLast() {
        System.out.println("---------------------------");
        System.out.println("Now we remove the last element of the array");
        System.out.println("Array before removing:");
        ARRAY.printArray();
        System.out.println("We removed: " + ARRAY.removeLast());
        System.out.println("Array after removing:");
        ARRAY.printArray();
    }

    /**
     * Tests foreach iterator for MyLinkedList.
     */
    private void testForeach() {
        System.out.println("---------------------------");
        System.out.println("We create following LinkedList to test foreach: ");
        MyLinkedList<Integer> arr = new MyLinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(null);
        arr.add(4);
        arr.add(5);
        arr.printArray();

        System.out.println("Now we iterate this LinkedList using foreach");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    /**
     * Tests contains(null).
     */
    private void testContainsNull() {
        System.out.println("---------------------------");
        System.out.println("We create following LinkedList to test contains(null): ");
        MyLinkedList<Integer> arr = new MyLinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(null);
        arr.add(4);
        arr.add(5);
        arr.printArray();

        System.out.println("Contains 3? - " + arr.contains(3));
        System.out.println("Contains null? - " + arr.contains(null));
        System.out.println("Contains 5? - " + arr.contains(5));
    }
}
