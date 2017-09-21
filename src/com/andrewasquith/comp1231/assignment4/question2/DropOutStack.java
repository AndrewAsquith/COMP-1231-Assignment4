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
 * 
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
	 * Pointer to track the element in the array that is currently the top of
	 * the stack
	 */
	private int top;

	/**
	 * Counter to track the number of elements in the stack
	 */
	private int counter;

	/**
	 * Default constructor that initializes the underlying array to
	 * DEFAULT_CAPACITY
	 */
	public DropOutStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor taking an initial size for the underlying array that backs
	 * the stack
	 */
	@SuppressWarnings("unchecked")
	public DropOutStack(int capacity) {

		// need to cast to an Array of T since we can't instantiate
		// the generic type
		// use the annotation to suppress the compiler warning
		stack = (T[]) (new Object[capacity]);
		// set the top of the stack to position -1 when it's empty
		top = -1;
		counter = 0;

	}

	/**
	 * Adds an element to the top of stack If the underlying array is full the
	 * top pointer will wrap around back to 0
	 */
	public void push(T element) {

		if (top == stack.length - 1) {
			
			// if stack is full, move back to 0 and add the element
			top = 0;
			stack[top] = element;
			
		} else {

			// otherwise increment top and then add the element 
			// to that index in the array
			stack[++top] = element;
		}
		
		// if the stack isn't full currently, increment the counter
		if (counter < stack.length) {
			counter++;
		}
	}

	/**
	 * Removes the topmost element and returns a reference to it
	 * 
	 * @return element from top of the stack
	 * @throws EmptyCollectionException
	 *             if the stack is empty
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

		//decrement the counter
		counter--;

		// if the stack isn't empty
		if (!isEmpty()) {
			
			// and top points at index 0
			if (top == 0) {
				
				// move the top pointer back to bottom
				top = stack.length - 1;
				
			} else {
				
				// otherwise just decrement top
				top--;
			}
		}

		// and return the reference to the element
		return element;
	}

	/**
	 * Returns a reference to the element at the top of the stack.
	 * 
	 * @return element on top of stack
	 * @throws EmptyCollectionException
	 *             if stack is empty
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
	 * 
	 * @return true if this stack is empty
	 */
	public boolean isEmpty() {
		// need to check if size is 0 since top may have wrapped
		return size() == 0;
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return the number of elements in the stack
	 */
	public int size() {

		// return the counter variable
		return counter;
	}

	/**
	 * toString implementation
	 * 
	 * @return a string representation of the stack
	 */
	public String toString() {
		String representation = "<TOP OF STACK>" + System.lineSeparator();

		// if top is less than the current size it has wrapped
		if (top <= size()) {
			
			// top is pointing somewhere other than the last element
			for (int i = top; i >= 0; i--) {
				
				// do top to index 0, skipping values which are null
				if (stack[i] != null) {
					representation += stack[i] + System.lineSeparator();
				}
			}

			for (int i = stack.length - 1; i > top; i--) {
				// do end of array to top, skipping values which are null
				if (stack[i] != null) {
					representation += stack[i] + System.lineSeparator();
				}
			}

		} else {

			// haven't wrapped around, just print from top to 0
			for (int i = top; i >= 0; i--) {
				representation += stack[i] + System.lineSeparator();
			}
		}
		representation += "<BOTTOM OF STACK>";
		
		return representation;
	}

	/*
	 * Debug version of toString that shows the actual layout of the array
	 * and where the top element currently points to
	 */
	protected String printDebug() {
		
		String representation = "[DEBUG]<START OF ARRAY>" + System.lineSeparator();
		
		// debug version iterates whole array and prints null elements
		for (int i = 0; i <= stack.length - 1; i++) {
			representation += "[DEBUG]" + stack[i];
			
			//mark the current top location
			if (top == i) {
				representation += "[TOP]";
			}

			representation += System.lineSeparator();
		}
		representation += "[DEBUG]<END OF ARRAY>";
		
		return representation;
	}

}
