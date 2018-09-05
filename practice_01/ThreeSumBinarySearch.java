package practice_01;

import java.util.Arrays;

/**
 * 统计一个数组中和为 0 的三元组数量
 */
public class ThreeSumBinarySearch {

    public int count(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = -nums[i] - nums[j];
                int index = BinarySearch.search(nums, target);
                // 应该注意这里的下标必须大于 j，否则会重复统计。
                if (index > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (l + h)/2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target) {
                l += 1;
            }else {
                m += 1;
            }
        }

        return -1;
    }
}
