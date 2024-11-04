package com.day;
@FunctionalInterface
interface StringLength{
	int length(String s);
}

public class Demo2 {

	public static void main(String[] args) {
   StringLength s1= s->s.length();
   String testString1 = "Hello, World!";
   String testString2 = "Lambda expressions in Java";
   String testString3 = "";

   System.out.println("Length of '" + testString1 + "': " + s1.length(testString1)); // Output: 13
   System.out.println("Length of '" + testString2 + "': " + s1.length(testString2)); // Output: 31
   System.out.println("Length of empty string: " +         s1.length(testString3)); // Output: 0
     // System.out.println(s1.length("sow"));
	}

}
