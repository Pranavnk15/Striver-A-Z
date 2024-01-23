/*402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

Approach:-
when you are standing at a particular index then we make a descision to delete a 
number, when we see a lower element to its right, then we delete the curr element, we check the top of the
stack to be greater than the curr element, if the top element is greater, we pop it
and compare it with the next top element. 

*/
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        for(; i<num.length() && k >0; ) {
            while(k>0 && !s.isEmpty() && num.charAt(i) < s.peek()) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
            i++;
        }

        while(!s.isEmpty() && k>0) {
            s.pop();
            k--;
        }

        String ans = "";
        while(!s.isEmpty()) {
            ans = s.pop()+ans;
        }
        ans = ans + num.substring(i, num.length());

        //0002000
        i = 0;
        while(i<ans.length()) {
            if(ans.charAt(i) == '0'){
                i++;
            } else {
                break;
            }
        }
        return ans.substring(i).length()==0 ? "0":ans.substring(i);
    }
}