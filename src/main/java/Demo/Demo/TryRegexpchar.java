package Demo.Demo;

import java.util.Arrays;

public class TryRegexpchar {

			// TODO Auto-generated method stub
		
			static String strfinal = null;
			static String lengthString[];

			private static void mixedString(String str) {
				strfinal = strfinal + "" + str;
				strfinal.toLowerCase();
			}

			private static void removeduplicatevalue(String str) {
			  //-- Reduce String without Occurance 
			  //-- ex. aaabbbcccss then  char array its store as a, b, c, s
			  //-- This char will use for split the original string
				char ch[] = strfinal.replaceAll("[ ]+", "")
						     .replaceAll("(.)(?=.*\\1)", "").toCharArray();
			  
			  //--  Store a String for letter as (Count of char)+(char) by using Char split
			  //--  Ex. String aaabb, then lengthString Array store as 3a, 2b
				lengthString= new String[ch.length]; int i = 0;
				
				for (char chr : ch) {
					lengthString[i] = "" + (strfinal.split("" + chr+ "").length-1) 
							             + chr;
					i = i + 1;}
			}

			private static void printvalue(String[] lengthString, int maxPrint) {
				//--Sorting the Count+Ch string as ascending order
				Arrays.sort(lengthString);
				
				//-- Print last three values
				int count = lengthString.length;
				for (int j = count - 1; j >= count - maxPrint; j--)
					System.out.print(lengthString[j].replaceAll("[0-9]", ""));
			}

			public static void main(String[] args) {
				String s[] = { "abc", "abcd","abcde","abcdef"};

				// Convert Array to Single String
				for (String str : s) {
					mixedString(str);
				}

				// Remove duplicate value for using Split method
				// Store String value as (count+Charcter) string 
				removeduplicatevalue(strfinal);

				// Print First three value
				printvalue(lengthString, 3);
			}
		
	

}
