/*
 * Andrew Asquith
 * COMP 1231
 * Assignment 4
 * Question 1 - Implementation of ArrayStack<T>
 */
package com.andrewasquith.comp1231.assignment4.question1;

// since this is the exception thrown it needs to be imported in order to be caught
import jsjf.exceptions.EmptyCollectionException;

/**
 * Driver class for the ArrayStack<T> implementation
 * Runs through multiple push/pop/peeks and prints
 * the state of the stack after each to exercise all the functionality
 * @author Andrew
 *
 */
public class ArrayStackDriver {

	public static void main(String[] args) {
		
		// new ArrayStack of Integers with capacity of 5
		ArrayStack<Integer> astack = new ArrayStack<Integer>(5);
		
		System.out.println("Empty Stack:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("isEmpty() and size() with empty stack:");
		System.out.println("isEmpty() = " + astack.isEmpty());
		System.out.println("size() = " + astack.size());
		System.out.println();
		
		System.out.println("Peek an empty stack");
		try {
			astack.peek();
		} catch (EmptyCollectionException e){
			System.out.println("Caught Exception: " + e.getMessage());
		}
		System.out.println();
		
		System.out.println("Pop an empty stack");
		try {
			astack.pop();
		} catch (EmptyCollectionException e){
			System.out.println("Caught Exception: " + e.getMessage());
		}
		System.out.println();
		
		System.out.println("Push #3 onto stack");
		astack.push(new Integer(3));
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("Push 7 and 2 onto stack");
		astack.push(new Integer(7));
		astack.push(new Integer(2));
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("isEmpty() and size() with 3 elements");
		System.out.println("isEmpty() = " + astack.isEmpty());
		System.out.println("size() = " + astack.size());
		System.out.println();
		
		System.out.println("Peek - should be 2");
		System.out.println("Peeked: " + astack.peek());
		System.out.println();
		
		System.out.println("Push 5 onto stack");
		astack.push(new Integer(5));
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("Pop from stack - should be 5");
		System.out.println("Popped: " + astack.pop());
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("Exceed initial capacity - push 2,3,4");
		astack.push(new Integer(2));
		astack.push(new Integer(3));
		astack.push(new Integer(4));
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("Peek after exceeding initial capacity");
		System.out.println("Peeked - " + astack.peek());
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
		
		System.out.println("Pop after exceeding initial capacity");
		System.out.println("Popped - " + astack.pop());
		System.out.println("Stack State:");
		System.out.println(astack);
		System.out.println();
	}

}
