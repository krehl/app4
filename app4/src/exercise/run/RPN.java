/**
 * 
 */
package exercise.run;

import java.util.*;
import algebra.*;
//import java.io.*;

/**
 * @author Konstantin Krehl
 *
 */
public class RPN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<NormRational> stack = new Stack<NormRational>();
		//System.out.println(args);
		
		String[] input = args[0].split(" ");
		//System.out.println(input);
		//System.out.println(input.length);
		for (int i = 0; i < input.length; ++i) {
			//System.out.println(stack);
			//System.out.println("i " + Integer.toString(i));
			//System.out.println(input[i]);
			if (Character.isDigit(input[i].charAt(0))) {
				stack.push(new NormRational((long)Integer.parseInt((input[i]))));
			} else {
				//System.out.println(input[i]);
				if 			("+".equals(input[i])) {
					stack.push(NormRational.add(stack.pop(),stack.pop()));
				} else if 	("-".equals(input[i])) {
					NormRational a = stack.pop();
					//NormRational b = stack.pop();
					stack.push(NormRational.sub(stack.pop(),a));
				} else if 	("*".equals(input[i])) {
					stack.push(NormRational.mult(stack.pop(),stack.pop()));
				} else if 	("/".equals(input[i])) {
					NormRational a = stack.pop();
					//NormRational b = stack.pop();
					stack.push(NormRational.div(stack.pop(),a));
				}
			}
		}
		System.out.println(stack.pop());
	}

}
