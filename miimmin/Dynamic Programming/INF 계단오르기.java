// 1, 2 term으로 N계단을 오를 경우의 수

// 1 -> 1
// 2 -> 1+1, 2
// 3 -> 1+1+1, 1+2, 2+1
// 4 -> 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2

import java.util.*;

class Main{

    public static int sol(int n){
        int[] cas = new int[n+1];
        cas[1] = 1;
        cas[2] = 2;
        for(int i=3; i<=n; i++){
            cas[i] = cas[i-2] + cas[i-1];
        }

        return cas[n];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(sol(n));
    }
}