//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 565 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
        int[] nums = new int[]{0,2,1,-3};
        int i = solution.threeSumClosest(nums, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int compare = Integer.MAX_VALUE;
            int res = 0;
            for (int k = 0; k < nums.length - 2; k++) {
                if (k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        while (i < j && nums[j] == nums[--j]) ;
                        compare = Math.min(Math.abs(sum - target), compare);
                        if (compare == Math.abs(sum - target))
                            res = sum;
                    } else {
                        while (i < j && nums[i] == nums[++i]) ;
                        compare = Math.min(Math.abs(target - sum), compare);
                        if (compare == Math.abs(sum - target))
                            res = sum;
                    }
                }

        }
            return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}