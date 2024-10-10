/*

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

 */
import java.util.*;
public class DecodeString {

	public static void main(String[] args) {
		String[] test_cases = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
		
		for(int i = 0; i < 3; i++) {
			System.out.printf("Test case %d: %s Solution: %s \n", i, test_cases[i], decodeString(test_cases[i]) );
		}
	}
	public static String decodeString(String s) {
		
		Stack <Integer> num_stack = new Stack<>();
        Stack <String> str_stack = new Stack<>();

        String number = "";
        String ss = "";
        int num;
        String ps;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                number += c;
            }
            else if( !number.isEmpty()){
                num_stack.push(Integer.parseInt(number));
                number = "";
            }

            if( c == '['){
                str_stack.push(ss);
                ss = "";
            }
            else if(c == ']'){
                num = num_stack.pop();
                ps = str_stack.pop();

                for(int i = 0; i < num; i++){
                    ps += ss;
                }
                ss = ps;
            }

            if(Character.isLetter(c)){
                ss += c;
            }
        }
        return ss;
        
    }

}
