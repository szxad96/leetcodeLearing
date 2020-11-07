package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Su Zexuan
 * @create: 2020-11-07 20:08
 **/
class test {
    public int[][] findContinuousSequence(int target) {
        //首先定义两个指针，代表窗口的左右边界
        List<int[]> result = new ArrayList<>();

        int left = 1;
        int right = 1;
        int sum = 0;
        while (left <= target / 2) {

            if (sum < target) {
                sum += right;
                right ++;
            } else if (sum > target) {
                sum -= left;
                left ++;
            } else {
                int[] res = new int[right - left];
                for (int i = 0; i < res.length; i++) {
                    res[i] = left++;
                }
                result.add(res);
                //当目前匹配到了一个结果，为了求出所有的结果，让左边界++即可，继续遍历
                left++;
                sum -= left;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new test().findContinuousSequence(10);

    }
}