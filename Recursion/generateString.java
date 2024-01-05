// Problem statement
// You have been given an integer 'N'. Your task is to generate and return all binary strings of length 'N' such that there are no consecutive 1's in the string.



// A binary string is that string which contains only ‘0’ and ‘1’.



// For Example:
// Let ‘N'=3, hence the length of the binary string would be 3. 

// We can have the following binary strings with no consecutive 1s:
// 000 001 010 100 101 








import java.util.List;

public class Solution {
    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> ans = new ArrayList<>();

        if(N == 0) {
            return ans;
        }

        char str[] = new char[N];
        str[0] = '0';
        helper(N, str, 1, ans);
        str[0] = '1';
        helper(N, str, 1, ans);
        Arrays.sort(str);
        return ans;
    }
    public static void helper(int k, char[] str, int n, List<String> ans) {
        if(n == k) {
            ans.add(new String(str));
            return;
        }

          if (str[n - 1] == '1') {
            str[n] = '0';
            helper(k, str, n + 1, ans);
        }

		/*
			If previous character is '0' then we put
			both '1' and '0' at end of string.
			Example str = "00" then new string is "001" and "000".
		*/
        if (str[n - 1] == '0') {
            str[n] = '0';
            helper(k, str, n + 1, ans);
            str[n] = '1';
            helper(k, str, n + 1, ans);
        }
    }
}
