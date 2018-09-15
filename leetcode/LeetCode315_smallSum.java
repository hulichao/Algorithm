package leetcode;


/**
 * 求所有小和问题
 * Created by hulichao on 2018/9/15
 */
public class LeetCode315_smallSum {

    public static void main(String[] args) {
        int[] in = new int[] {5, 2, 6, 1};
        int a = countSmaller(in);
        System.out.println(a);
    }

    public static int countSmaller(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int  mergeSort(int[] nums, int l, int r) {
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(nums, l , mid) + mergeSort(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    private static int merge(int [] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            if (nums[p1] < nums[p2]) {
                res += nums[p1] * (r - l + 1);
                help[i++] = nums[p1++];
            }else {
                help[i++] = nums[p2++];
            }
        }
        while(p1 <= m) {
            help[i++] = nums[p1++];
        }

        while(p2 <= r) {
            help[i++] = nums[p2++];
        }

        return res;
    }
}
