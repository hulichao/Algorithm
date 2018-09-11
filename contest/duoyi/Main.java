package contest.duoyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ins = in.nextLine();
        int x = Integer.valueOf(ins.split(",")[0]);
        int y = Integer.valueOf(ins.split(",")[1]);

        String str = in.nextLine();
        String[] sarr = str.split(",");
        int[] xarr = new int[sarr.length/2];
        int[] yarr = new int[sarr.length/2];
        int k=0,m=0;
        for (int i = 0; i < sarr.length; i++) {
            if (i % 2 == 0) xarr[k++] = Integer.valueOf(sarr[i]);
            else yarr[m++] = Integer.valueOf(sarr[i]);
        }

        System.out.println(isInPolygon(x,y,xarr,yarr));
//        if (isInPolygon(x,y,xarr,yarr) == -1) {
        if(false){
            int minDep = Integer.MAX_VALUE;
            for (int i = 0; i < xarr.length; i++) {
                int h = 0;
                if (i == xarr.length - 1)
                    h = pDistance(x,y,xarr[i],yarr[i],xarr[0],yarr[0]);
                else h = pDistance(x,y,xarr[i],yarr[i],xarr[i+1],yarr[i+1]);
                if (h < minDep) {
                    minDep = h;
                }
            }
            System.out.println("no," + minDep);
            return;
        }
        System.out.println("yes,0");
    }


    public static int pDistance(int x, int y, int x1, int y1, int x2, int y2) {
        int A = x - x1;
        int B = y - y1;
        int C = x2 - x1;
        int D = y2 - y1;
        int E = -D;
        int F = C;
        int dot = A * E + B * F;
        int len_sq = E * E + F * F;
        return (int)(Math.abs(dot)/Math.sqrt(len_sq));
    }

    public static int isInPolygon(int x, int y, int[] xArray, int[] yArray)
    {
        int sidesCount = xArray.length;
        if(sidesCount < 3)
            return -1;

        int intersectionCount = 0;
        for(int i = 0; i < sidesCount; i++)
        {
            int j = (i + 1)%sidesCount;
            if(xArray[i] > x && xArray[j] > x )
                continue;

            if((y - yArray[i])*(y-yArray[j]) > 0)
                continue;

            if((y-yArray[i])*(x-xArray[j]) == (y-yArray[j])*(x-xArray[i]))
                return 0;

            if(yArray[i] < y || yArray[j] < y)
                intersectionCount++;
        }

        if(intersectionCount % 2 == 1)
            return 1;
        else
            return -1;
    }

}
