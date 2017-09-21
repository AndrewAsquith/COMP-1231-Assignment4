/*
 * Andrew Asquith
 * COMP 1231
 * Assignment 4
 * Question 2 - Implementation of DropOutStack<T>
 */
package com.andrewasquith.comp1231.assignment4.question2;

// since this is the exception thrown it needs to be imported in order to be caught
import jsjf.exceptions.EmptyCollectionException;

/**
 * Driver class for the DropOutStack<T> implementation
 * Runs through multiple push/pop/peeks and prints
 * the state of the stack after each to exercise all the functionality
 * pass the argument DEBUG on the command line to see the state of the
 * underlying array after the operations in addition to the stack
 * @author Andrew
 *
 */
public class DropOutStackDriver {

	public static void main(String[] args) {
		
		// don't print debug information unless requested
		boolean DEBUG = false;
		
		// if debug was provided as argument set the flag to true
		if (args.length > 0) {
			if (args[0].toLowerCase().equals("debug")) {
				DEBUG = true;
			}
		}
		
		// new DropOutStack of Integers with capacity of 5
		DropOutStack<Integer> dropStack = new DropOutStack<Integer>(5);
		
		System.out.println("Empty Stack:");
		System.out.println(dropStack);
		System.out.println();
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("isEmpty() and size() with empty stack:");
		System.out.println("isEmpty() = " + dropStack.isEmpty());
		System.out.println("size() = " + dropStack.size());
		System.out.println();
		
		System.out.println("Peek an empty stack");
		try {
			dropStack.peek();
		} catch (EmptyCollectionException e){
			System.out.println("Caught Exception: " + e.getMessage());
		}
		System.out.println();
		
		System.out.println("Pop an empty stack");
		try {
			dropStack.pop();
		} catch (EmptyCollectionException e){
			System.out.println("Caught Exception: " + e.getMessage());
		}
		System.out.println();
		
		System.out.println("Push #3 onto stack");
		dropStack.push(new Integer(3));
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("Push 7 and 2 onto stack");
		dropStack.push(new Integer(7));
		dropStack.push(new Integer(2));
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("isEmpty() and size() with 3 elements");
		System.out.println("isEmpty() = " + dropStack.isEmpty());
		System.out.println("size() = " + dropStack.size());
		System.out.println();
		
		System.out.println("Peek - should be 2");
		System.out.println("Peeked: " + dropStack.peek());
		System.out.println();
		
		System.out.println("Push 5 onto stack");
		dropStack.push(new Integer(5));
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("Pop from stack - should be 5");
		System.out.println("Popped: " + dropStack.pop());
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("Exceed initial capacity - push 2,3,4");
		dropStack.push(new Integer(2));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 2");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		dropStack.push(new Integer(3));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 3");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		dropStack.push(new Integer(4));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 4");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		
		System.out.println("Peek after exceeding initial capacity");
		System.out.println("Peeked - " + dropStack.peek());
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("Pop after exceeding initial capacity");
		System.out.println("Popped - " + dropStack.pop());
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		
		System.out.println("After exceed initial capacity and popping - push 5,6,7");
		dropStack.push(new Integer(5));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 5");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		dropStack.push(new Integer(6));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 6");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		dropStack.push(new Integer(7));
		if(DEBUG) {
			System.out.println("[DEBUG]PUSH 7");
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();

		System.out.println("Pop after exceeding initial capacity again");
		System.out.println("Popped - " + dropStack.pop());
		System.out.println("Stack State:");
		System.out.println(dropStack);
		System.out.println();
		if(DEBUG) {
			System.out.println(dropStack.printDebug());
			System.out.println();
		}
	}

}
