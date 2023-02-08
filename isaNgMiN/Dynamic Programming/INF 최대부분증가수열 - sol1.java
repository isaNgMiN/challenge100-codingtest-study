// N개의 자연수로 이루어진 수열
// 가장 길게 증가하는 원소들의 집합
//   숫자는 주어진 순서대로
//   증가하도록 뽑았을때 가장 많은 원소를 뽑을 수 있는 경우의
//   그때의 원소수

// 포문뒤에서부터 돈다
// 내앞의 가장 큰아이+1

import java.util.*;

class Main{

    public static int sol(int n, int[] t){
        int[] tans = new int[n];
        tans[n-1] = 1;
        ArrayList<Integer> er = new ArrayList<>();

        int ans = 0;
        for(int i=n-2; i>=0; i--){
            int comp = i;
            for(int j=i+1; j<n; j++){
                if(t[comp] < t[j]) er.add(tans[j]);
            }
            if(!er.isEmpty()) tans[i] = Collections.max(er) + 1;
            else tans[i] = 1;
            er.clear();
            ans = Math.max(ans, tans[i]);
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for(int i=0; i<n; i++){
            t[i] = sc.nextInt();
        }

        System.out.print(sol(n,t));
    }
}