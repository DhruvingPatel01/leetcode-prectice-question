import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
           
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
       
            if (nums[i] <= remain) {
                current.add(nums[i]);
                
                backtrack(nums, remain - nums[i], i, current, result);
   
                current.remove(current.size() - 1);
            }
        }
    }
}
