/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. 
If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

import java.util.*;
public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid: asteroids){

            boolean destroyed = false;

            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){

                if( Math.abs(asteroid) > Math.abs(stack.peek())){
                    stack.pop();
                } else if (Math.abs(asteroid) == Math.abs(stack.peek())){
                    stack.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }

                
            }
            if(!destroyed){
                    stack.push(asteroid);
                }
        }
        int[] final_stack = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--){
            final_stack[i] = stack.pop();
        }
        return final_stack;


    }

}
