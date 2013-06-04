package exercise.run;

import java.util.*;

import algebra.number.*;

import exercise.adt.*;

public class TestRBT {

	public TestRBT() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length==0){
			System.out.println("Usage: TestBST 'first tree 0 0 second tree'");
			return;
		}
		
		BinarySearchTree<CompRational> first = new BinarySearchTree<CompRational>(); //ändern auf RBT
		//BinarySearchTree<CompRational> second = new BinarySearchTree<CompRational>();
		boolean f = true;
		String[] input = args[0].split(" ");
		for (int i = 0; i < input.length; i+=2) {
			try {
				long a = (long)Integer.parseInt((input[i]));
				long b = (long)Integer.parseInt((input[i+1]));
				if (f) {
					if (a==0 && b==0) {
						f = false;
					} else {
						try {
							first.insert(new CompRational(a,b));
							System.out.println(first.toString());
						} catch (IllegalArgumentException e) {
							System.out.println("Schon vorhanden, mache weiter");
						}
						
					}
				} else {
					try {
						first.remove(new CompRational(a,b));
						System.out.println(first.toString());
					} catch (IllegalArgumentException e) {
						//e.printStackTrace();
						System.out.println("Nicht enthalten, mache weiter");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Falsches Eingabeformat, nächste Zahl");
				continue;
			}
		}
		
		System.out.println(first.toString());
	}
	
	static boolean cond(Object obj) {
		if (obj.getClass() != RedBlackTree.Node.class) {
			return false;
		}
		obj = (RedBlackTree<CompRational>.Node) obj;
		return true;
	}
		
	public static void filter(Collection<?> c) {
	    for (Iterator<?> it = c.iterator(); it.hasNext(); )
	        if (!cond(it.next()))
	            it.remove();
	}
}
