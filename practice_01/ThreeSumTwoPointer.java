package practice_01;

import java.util.Arrays;

/**
 * 统计一个数组中和为 0 的三元组数量
 */
public class ThreeSumTwoPointer {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,-5};
        System.out.println(count(nums));
    }
    
    public static int count(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int ret = 0;
        for (int i = 0; i < N - 2; i++) {
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, h = N - 1;
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum == target) {
                    System.out.println(nums[l] + "+" + nums[h] + "+" + -target + "=" + "0");
                    ret++;
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                }else if (sum < target){
                    l++;
                }else {
                    h--;
                }

            }

        }
        return ret;
    }
}
