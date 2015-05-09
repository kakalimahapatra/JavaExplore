package com.itu.assignments;

import java.util.Stack;
import java.util.Vector;

public class PileOfBooks {  // Pile of Books implementation using Stack

	/* A stack is used here instead of a queue because in a queue 
	because of its LIFO nature the numbering of the books will change but in a stack because the books
	will be removed in an orderly manner the position and numbering of the books won't change*/

	public static void main(String[] args) {

		Stack bookpile = new Stack();
		System.out.println("Welcome to the Bookpile");
		System.out.println("Enter books");

		bookpile.push("book1");
		bookpile.push("book2");
		bookpile.push("book3");
		bookpile.push("book4"); 
		bookpile.push("book5"); 
		bookpile.push("book6"); 
		bookpile.push("book7");  // Because its a bookpile, the books are stacked one upon another

		System.out.println("The stack of books is: " +bookpile);
		
		//Now we want to remove the top book of the stack
		bookpile.pop();
		System.out.println("The stack of books is: " +bookpile);
		
		/*we want to remove the book4 which is now 3rd book of the stack from top, 
		 * so we have to remove the 1st 2 books from the top and then the 3rd 
		 * book is accessible to us*/
		
		bookpile.pop();
		bookpile.pop();
		bookpile.pop();
		System.out.println("The stack of books is: " +bookpile);
		
		/*we have to now add the rest of the books to the pile*/
		bookpile.push("book5");
		bookpile.push("book6");
		System.out.println("The stack of books is: " +bookpile);
		
		
		

	}

}




