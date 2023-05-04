// 동전 거스름든을 가장 적은 수의 동전으로 교환

// sorting -> 나누기의몫

import java.util.*;

class Main{

    public static int sol(int n, int m, ArrayList<Integer> t){
        int ans = 0;
        int[] tans = new int[m+1];
        Arrays.fill(tans, Integer.MAX_VALUE);
        tans[0] = 0;

//        Collections.sort(t, Collections.reverseOrder());
        Collections.sort(t);

        int tmp = m;
        for(int e:t){
            for(int i=e; i<=m; i++){
                tans[i] = Math.min(tans[i-e]+1, tans[i]);
            }
        }
        ans = tans[m];

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> t = new ArrayList<>();
        for(int i=0; i<n; i++){
            t.add(sc.nextInt());
        }
        int m = sc.nextInt();

        System.out.print(sol(n,m,t));
    }
}