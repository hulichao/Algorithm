package contest.ali;

import java.util.*;

public class Main2 {
    private static int GR = 0;

    public static void main(String[] args) {
        Scanner ins = new Scanner(System.in);
        int k = Integer.parseInt(ins.nextLine());
        int[] nums = new int[k];GR = k;
        int i = 0;int count = 0;
        while(i < k) {
            nums[i] = Integer.parseInt(ins.nextLine());
            i++;
        }
        List<List<Integer>> lists = getSets(nums);
        HashMap<Integer, Integer> input = new HashMap<>();
        for (int e = 0; e < lists.size(); e++){
            List<Integer> tmp = lists.get(e);
            input.clear();
            for(int g = 1; g < tmp.size() - 1; g++) {
                if((tmp.get(g + 1) - tmp.get(g)) == (tmp.get(g) - tmp.get(g -1))) count++;
                else if(tmp.get(g+1)/tmp.get(g) == tmp.get(g)/tmp.get(g -1)) count++;
            }
        }
        System.out.println(input.size());
    }

    public static List<List<Integer>> getSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> res ,List<List<Integer>> result , List<Integer> onList, int [] nums, int start) {
        if((onList.size() >= 3 && GR - onList.size() >= 3) || onList.size() == GR)
            result.add(new ArrayList<>(onList));
        for (int i = start; i < nums.length; i++) {
            onList.add(nums[i]);
            backtrack(res,result, onList, nums, i + 1);
            onList.remove(onList.size() - 1);
        }
    }
}