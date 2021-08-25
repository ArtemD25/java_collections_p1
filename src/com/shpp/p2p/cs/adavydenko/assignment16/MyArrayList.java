package com.shpp.p2p.cs.adavydenko.assignment16;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a copy of an ArrayList class with
 * only several most used methods provided.
 *
 * @param <T> stands for a type of the elements that will be stored in the array
 */
public class MyArrayList<T> implements Iterable<T> {

    /**
     * Number of object already added to the MyArrayList
     */
    private int numOfAddedObjects = 0;

    /**
     * The default size of the array when it is created.
     */
    private final int DEFAULT_SIZE = 10;

    /**
     * The internal array that stores all information
     * provided to MyArrayList.
     */
    private T[] array;

    /**
     * Creates an instance of an array in order to put elements to it.
     */
    @SuppressWarnings("uncheked")
    public MyArrayList() {
        this.array = (T[]) (new Object[DEFAULT_SIZE]);
    }

    /**
     * Returns the number of objects added to the array.
     *
     * @return the number of objects added to the array
     */
    public int size() {
        return numOfAddedObjects;
    }

    /**
     * Adds an object provided by user to the end of the array.
     *
     * @param obj any object provided by user.
     * @return true if object added.
     */
    public boolean add(T obj) {
        if (numOfAddedObjects >= array.length) {
            array = createNewArray(array, getNewLength(array.length));
        }
        array[numOfAddedObjects] = obj;
        numOfAddedObjects++;
        return true;
    }

    /**
     * Adds all items of an array (arrayToAdd) to another array.
     *
     * @param arrayToAdd is an array with items to be added to another array.
     */
    public void addAll(MyArrayList<T> arrayToAdd) {
        for (int i = 0; i < arrayToAdd.size(); i++) {
            add(arrayToAdd.get(i));
        }
    }

    /**
     * Adds an object provided by user and places it to the
     * index provided by user as a first argument. All other
     * objects of the array if any are shifted to the right.
     *
     * @param index the index in the array for the object provided.
     * @param obj   any object provided by user.
     */
    public void add(int index, T obj) {
        if (index < 0 || index > numOfAddedObjects) { // If such index does not exist
            throw new IndexOutOfBoundsException();
        } else if (index == numOfAddedObjects - 1) { // if one shall insert an object in the end of the array
            add(obj);
        } else { // if an object shall be inserted in the middle
            if (numOfAddedObjects == array.length) {
                array = createNewArray(array, getNewLength(array.length));
            }
            if (numOfAddedObjects - index >= 0) // shifts all needed objects to the right
                System.arraycopy(array, index, array, index + 1, numOfAddedObjects - index);
            array[index] = obj;
            numOfAddedObjects++;
        }
    }

    /**
     * Substitutes already existing element with provided index
     * in the array by another element provided by user.
     *
     * @param index is the index of element in the array that shall be substituted.
     * @param obj   a new object shall be put to the array.
     * @return the object added to the array.
     */
    public T set(int index, T obj) {
        if (index >= 0 && index < numOfAddedObjects) {
            array[index] = obj;
            return obj;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets an objects requested by user based on its index
     * in the array.
     *
     * @param index is index of the requested objects in the array.
     * @return the object under provided index.
     */
    public T get(int index) {
        if (index >= 0 && index < numOfAddedObjects) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Says whether the array contains the object the user provided
     * as an argument.
     *
     * @param obj any object provided by user.
     * @return true if the array contains such object.
     */
    public boolean contains(T obj) {
        for (int i = 0; i < numOfAddedObjects; i++) {
            if (array[i] == null || obj == null) {
                if (array[i] == null && obj == null) {
                    return true;
                }
            } else if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all objects from the array making them
     * equal to null and setting the array size to the default one.
     */
    @SuppressWarnings("uncheked")
    public void clear() {
        if (numOfAddedObjects > 0) {
            numOfAddedObjects = 0;
            // resets array to the default size for it not to take much memory
            array = (T[]) (new Object[DEFAULT_SIZE]);
        }
    }

    /**
     * Removes an element under provided by user index from the array. All other
     * elements that are placed to the right are shifted to the left.
     *
     * @param index is the index of the element that shall be removed.
     * @return the value that was removed.
     */
    public T remove(int index) {
        if (index >= 0 && index < numOfAddedObjects) {
            T obj = array[index];
            if (numOfAddedObjects - 1 - index >= 0)
                System.arraycopy(array, index + 1, array, index, numOfAddedObjects - 1 - index);
            array[numOfAddedObjects - 1] = null;
            numOfAddedObjects--;
            return obj;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the object provided by user from the array if
     * such objects exists. If not, prints a message to console.
     * If there are several such objects in the array, the program
     * will remove the first one of those (starting from the array`s left).
     *
     * @param obj is any object provided by user.
     */
    public void remove(T obj) {
        if (!contains(obj)) {
            throw new NoSuchElementException();
        } else {
            int index = -1;
            for (int i = 0; i < numOfAddedObjects; i++) {
                if (array[i] == null || obj == null) {
                    if (array[i] == null && obj == null) {
                        index = i;
                    }
                } else if (array[i].equals(obj)) {
                    index = i;
                }
            }
            remove(index);
        }
    }

    /**
     * Returns the index of the element requested. If the element does nit
     * exist the program returns -1.
     * If there are several such objects in the array, the program will return
     * the index of the first one of those (starting from the array`s left).
     *
     * @param obj any object provided to the program.
     * @return the index of the element requested.
     */
    public int indexOf(T obj) {
        if (!contains(obj)) {
            throw new NoSuchElementException();
        } else {
            int index = -1;
            for (int i = 0; i < numOfAddedObjects; i++) {
                if (array[i] == null || obj == null) {
                    if (array[i] == null && obj == null) {
                        return i;
                    }
                } else if (array[i].equals(obj)) {
                    index = i;
                }
            }
            return index;
        }
    }

    /**
     * Creates a new larger array if the previous one was not enough
     * to store all user`s data.
     *
     * @param sourceArr is the array which capacities is not enough.
     * @param newLength is the new length of an array to be created.
     * @return the new array with all items that were in the previous one.
     */
    @SuppressWarnings("uncheked")
    private T[] createNewArray(T[] sourceArr, int newLength) {
        T[] newArr = (T[]) (new Object[newLength]);

        System.arraycopy(sourceArr, 0, newArr, 0, sourceArr.length);

        return newArr;
    }

    /**
     * Calculates the new length of the array if the current one
     * is not enough to store all elements a user wants to.
     *
     * @param length is the current length of the array.
     * @return the new length of the array.
     */
    private int getNewLength(int length) {
        final int ENLARGE_COEFF = 200; // Coefficient to enlarge the current size of an array
        return length + ENLARGE_COEFF;
    }

    /**
     * Prints the MyArrayList to console with all
     * its items being displayed in one line and separated by a
     * comma. All the array`s data is surrounded by square brackets.
     */
    public void printArray() {
        System.out.print("\n[");
        for (int i = 0; i < numOfAddedObjects; i++) {
            if (i == numOfAddedObjects - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("]\n");
    }

    /**
     * Creates and returns a MyIterator object to enable
     * the MyArrayList object to use foreach loop.
     *
     * @return a MyIterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator(this);
    }

    /**
     * This class has description of three methods used to
     * created an iterator instance to enable the MyArrayList
     * object to use foreach loop
     */
    private class MyIterator implements Iterator<T> {

        /**
         * A link to a particular MyArrayList object whose
         * elements shall be iterated.
         */
        private final MyArrayList<T> LIST;

        /**
         * The index of an element in the MyArrayList object
         * that shall be provided now.
         */
        private int currentPosition;

        /**
         * Copies a link of a MyArrayList object to access the
         * elements that shall be iterated and sets the index
         * to begin with to zero.
         *
         * @param arr is a MyArrayList object whose elements shall
         *            be provided to iterator.
         */
        private MyIterator(MyArrayList<T> arr) {
            LIST = arr;
            currentPosition = 0;
        }

        /**
         * Says whether there is any element left in the MyArrayList
         * object that can be extracted and processed in a foreach loop.
         *
         * @return true if there is such element.
         */
        @Override
        public boolean hasNext() {
            return currentPosition < LIST.size();
        }

        /**
         * Provides the next element to process it
         * in the foreach loop.
         *
         * @return the next element of the MyArrayList object.
         */
        @Override
        public T next() {
            T object = LIST.get(currentPosition);
            currentPosition++;
            return object;
        }
    }
}
