package contest.duoyi;
import java.util.Scanner;

public class Mian4 {
    private static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] string = sc.nextLine().split("\\s+");
        int p = Integer.parseInt(string[0]);
        int q = Integer.parseInt(string[1]);
        int[][] DD = new int[p][2];
        int[] beVoter = new int[q + 1];
        int i = 0, count1 = 0;
        while(i < p) {
            string = sc.nextLine().split("\\s+");
            DD[i][0] = Integer.parseInt(string[0]);
            if(DD[i][0] == 1) count1++;
            //
            beVoter[DD[i][0]] ++;
            DD[i][1] = Integer.parseInt(string[1]);
            i++;
        }
        System.out.println(solve(DD, p - 1, count1));

    }

    public static int solve(int[][] DD, int idx, int score) {
        if(idx < 0) return 0;
        if(score < Min)
            Min = Math.min(solve(DD, idx - 1, ++score) + DD[idx][1], solve(DD, idx - 1, 0));
        return Math.min(solve(DD, idx - 1, ++score) + DD[idx][1], solve(DD, idx - 1, 0));
    }

}