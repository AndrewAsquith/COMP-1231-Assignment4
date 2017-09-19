/*
 * Andrew Asquith
 * COMP 1231
 * Assignment 4
 * Question 2 - Implementation of DropOutStack<T>
 */
package com.andrewasquith.comp1231.assignment4.question2;

import java.util.Arrays;

//import the interface definition on which the implementation is based
import jsjf.StackADT;
//re-use the exception to be consistent with the original implementation
import jsjf.exceptions.EmptyCollectionException;


/**
 * Implementation of an array based drop out stack
 * @author Andrew
 *
 */
public class DropOutStack<T> implements StackADT<T> {

	/**
	 * Static constant for a default initial capacity
	 */
	private final static int DEFAULT_CAPACITY = 100;
	
	/**
	 * Array of the generic type to act as the stack
	 */
	private T[] stack;
	
	/**
	 * Integer to track the element in the array that
	 * is currently the top of the stack
	 */
	private int top;
	
	/**
	 * Default constructor that initializes the
	 * underlying array to DEFAULT_CAPACITY
	 */
	public DropOutStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor taking an initial size for
	 * the underlying array that backs the stack
	 */
	@SuppressWarnings("unchecked")
	public DropOutStack(int capacity) {
		
		// need to cast to an Array of T since we can't instantiate 
		// the generic type 
		//use the annotation to suppress the compiler warning
		stack = (T[])(new Object[capacity]);
		// in this implementation "top" should point at the top most element
		// before T[0] has been populated use -1
		top = -1;
	}
	
	/**
	 * Adds an element to the top of stack
	 * If the underlying array is full 
	 * the capacity will be doubled
	 */
	public void push(T element) {
		if (size() == stack.length) {
			expandCapacity();
		}
		
		// increment top and then add the element to that index in the array
		stack[++top] = element;
	}

	/**
	 * Helper method that doubles the size of the stack
	 * array if it is full and a push is attempted
	 */
	private void expandCapacity() {
		stack = Arrays.copyOf(stack, stack.length * 2);
	}

    /**
     * Removes the topmost element and returns a reference to it
     * @return element from top of the stack
     * @throws EmptyCollectionException if the stack is empty 
     */
	public T pop() throws EmptyCollectionException {

		// if the stack is empty, throw the EmptyCollectionException
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}

		// otherwise, get the reference to the element at the top
		T element = stack[top];
		
		// and set that top position to null
		stack[top] = null;
		
		// then decrement the top pointer
		top--;
		
		//and return the reference to the element
		return element;
	}

    /**
     * Returns a reference to the element at the top of the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
	public T peek() throws EmptyCollectionException {
		// if the stack is empty throw the EmptyCollectionException
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		// return a reference to the element at the top of the stack
		return stack[top];
	}

    /**
     * Returns true if the stack is empty false if not. 
     * @return true if this stack is empty
     */
	public boolean isEmpty() {
		// top = -1 is the value to represent an empty stack
		return top == -1;
	}

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
	public int size() {

		//since top is pointing at the array which is 0 based, we need to add 1
		return top+1;
	}
	
	/**
	 * toString implementation
	 * @return a string representation of the stack
	 */
	public String toString() {
		String representation = "<TOP OF STACK>" + System.lineSeparator();
		for (int i = top; i >= 0; i--) {
			representation += stack[i] + System.lineSeparator();
		}
		
		representation += "<BOTTOM OF STACK>";
		return representation;
	}

}
