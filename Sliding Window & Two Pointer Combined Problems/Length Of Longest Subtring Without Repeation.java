/*3. Longest Substring Without Repeating Characters

Intuition
The intuition behind the 3 solutions is to iteratively find the longest substring without repeating characters by maintaining a sliding window approach. We use two pointers (left and right) to represent the boundaries of the current substring. As we iterate through the string, we update the pointers and adjust the window to accommodate new unique characters and eliminate repeating characters.

Approach 1 - Set
We use a set (charSet) to keep track of unique characters in the current substring.
We maintain two pointers, left and right, to represent the boundaries of the current substring.
The maxLength variable keeps track of the length of the longest substring encountered so far.
We iterate through the string using the right pointer.
If the current character is not in the set (charSet), it means we have a new unique character.
We insert the character into the set and update the maxLength if necessary.
If the character is already present in the set, it indicates a repeating character within the current substring.
In this case, we move the left pointer forward, removing characters from the set until the repeating character is no longer present.
We insert the current character into the set and continue the iteration.
Finally, we return the maxLength as the length of the longest substring without repeating characters.

Approach 2 - Unordered Map
We improve upon the first solution by using an unordered map (charMap) instead of a set.
The map stores characters as keys and their indices as values.
We still maintain the left and right pointers and the maxLength variable.
We iterate through the string using the right pointer.
If the current character is not in the map or its index is less than left, it means it is a new unique character.
6 We update the charMap with the character's index and update the maxLength if necessary.
If the character is repeating within the current substring, we move the left pointer to the next position after the last occurrence of the character.
We update the index of the current character in the charMap and continue the iteration.
At the end, we return the maxLength as the length of the longest substring without repeating characters.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int len = 0;
        while(right < n) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
}