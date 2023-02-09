// 제한시간안에 최대점수

import java.util.*;


class LE implements Comparable<LE>{
    int g;
    int t;
    public LE(int g, int t){
        this.g =g;
        this.t =t;
    }
    @Override
    public int compareTo(LE o){
        return this.t - o.t;
    }

}

class Main{

    public static int sol(int n, int m, ArrayList<LE> le){
        int ans = 0;
        int[] tans = new int[m+1];

        Collections.sort(le);

        for(LE e:le){
            for(int i=m; i>=e.t; i--){
                tans[i] = Math.max(tans[i], tans[i-e.t]+e.g);
                ans = Math.max(ans, tans[i]);
            }
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<LE> le = new ArrayList<>();
        for(int i=0; i<n; i++){
            le.add(new LE(sc.nextInt(), sc.nextInt()));
        }

        System.out.print(sol(n,m,le));

    }
}