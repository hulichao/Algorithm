package contest.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ins = in.nextLine();
        int result = 0;
        int n = Integer.valueOf(ins.split("\\s+")[0]);
        int k = Integer.valueOf(ins.split("\\s+")[1]);
        int t = Integer.valueOf(ins.split("\\s+")[2]);

        if (n <= 0 || n < k) {
            System.out.println(0);
            return ;
        }
        if (t == 1) {
            System.out.println(n - k + 1);
            return ;
        }
        int[] nums = new int[n];
        String insb = in.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(insb.split("\\s+")[i]);
        }

        for (int i = 0; i <= n-k; i++) {
            if (ifSuit(nums,i , i + k-1,t)) result++;
        }

        System.out.println(result);
    }

    public static boolean ifSuit(int[] nums, int start, int end, int cout) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            if (map.containsKey(nums[i])){
                int tem = map.get(nums[i]);
                map.put(nums[i], tem + 1);
            }else map.put(nums[i], 1);
        }

        for(Integer i : map.values()) {
            if (i >= cout) return true;
        }
        return false;
    }
}