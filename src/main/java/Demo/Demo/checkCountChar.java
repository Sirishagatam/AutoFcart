package Demo.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class checkCountChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] chk= {"abc","abcd","abcde","abc1","adef"};
		
				
		int tct=0;
		for(String sr:chk) {
			tct+=sr.length();
		}
		
		char[] nch=new char[tct];
		
		System.out.println("Total string length in array count: "+tct);
		
		/*for (int i=0;i<chk.length;i++) {
			nch[i]=chk[i].toCharArray();
		}
		
		
		for(char[] innerArray : nch) {
	            System.out.println(Arrays.toString(innerArray));
	            
	    }*/
		
	/*	int index=0;
		for(String s: chk) {
			System.arraycopy(s.toCharArray(), 0, nch, index, s.length());
			index+=s.length();
		}*/
		
							
		//System.out.println("char array count: "+nch.length);
		//System.out.println(Arrays.toString(nch));
		List<Character> newlist= new ArrayList<>();
		for(Character c:nch) {
			newlist.add(c);
		}
		System.out.println(newlist.size());
		
		Map<Character,Integer> hmap=new HashMap<Character,Integer>();
		
		for(Character i:newlist) {
			Integer j=hmap.get(i);
			hmap.put(i,(j==null) ? 1:j+1);
		}
		
		// displaying the occurrence of elements in the arraylist
        for (Map.Entry<Character, Integer> m : hmap.entrySet()) {
            System.out.println("Element " + m.getKey() + " "
                               + "occurs"
                               + ": " + m.getValue() + " times");
        }
        
          
	}
}


