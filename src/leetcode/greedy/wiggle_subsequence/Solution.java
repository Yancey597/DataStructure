package leetcode.greedy.wiggle_subsequence;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-12-20:03
 * @url https://leetcode.cn/problems/wiggle-subsequence/description/
 * @description 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * <p>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3)
 */

public class Solution {
    private int res;
    private boolean saveRes;

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new Solution().wiggleMaxLength(nums));
    }


    public int wiggleMaxLength(int[] nums) {
        int i = 1;
        int size = 1;
        while (i < nums.length) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (size == 1) {
                saveRes = nums[i] - nums[i - 1] > 0 ? true : false;
                i++;
                size++;
                continue;
            }

            boolean lastRes = nums[i] - nums[i - 1] > 0 ? true : false;
            if (lastRes == !saveRes) {
                size++;
                saveRes = lastRes;
            }
            i++;
        }

        return size;
    }

    @Test
    public void test() {
        int[] nums = {1, 7, 4, 9, 2, 5};
        int i = new Solution().wiggleMaxLength(nums);
        assertEquals(i, 6);
    }
}
