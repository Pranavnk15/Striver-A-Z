90 Subsets II

Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

class Solution {

    void sub(int ind,int[] nums,List<Integer>ds,List<List<Integer>>ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            sub(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        sub(0,nums,new ArrayList<>(),ans);
        return ans;
    }

        // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     Arrays.sort(nums);
    //     solve(0, nums, ans, new ArrayList<>());

    //     return ans;
    // }

    // public static void solve(int i, int[] nums, List<List<Integer>> ans, List<Integer> curr) {
    //     ans.add(new ArrayList<>(curr));
    //     for(int j = i; j<nums.length; j++) {
    //         if(j != i && nums[j] == nums[j-1]) continue;
    //         curr.add(nums[i]);
    //         solve(j+1, nums, ans, curr);
    //         curr.remove(curr.size()-1);
    //     }
        
        
    //     // if(i == nums.length) {
    //     //     ans.add(curr);
    //     //     return;
    //     // }

    //     // // if( i != 0 && nums[i] == nums[i-1]) {
    //     // //     solve(i+1, nums, ans, curr);
    //     // // }
    //     // List<Integer> temp = new ArrayList<>(curr);
    //     // temp.add(nums[i]);
    //     // solve(i+1, nums, ans, temp);
        
    //     // solve(i+1, nums, ans, curr);
    // }

}