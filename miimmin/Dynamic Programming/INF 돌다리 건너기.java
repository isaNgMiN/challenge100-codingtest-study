// N개의 돌로 다리를 만들었다
// 최소단위 1, 2

import java.util.*;

class Main{

    public static int sol(int n){
        int[] nc = new int[n+2];
        nc[1] = 1;
        nc[2] = 2;

        for(int i=3; i<=n+1; i++){
            nc[i] = nc[i-2] + nc[i-1];
        }

        return nc[n+1];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(sol(n));
    }
}