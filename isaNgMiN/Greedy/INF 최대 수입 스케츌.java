// N개 기업강연요청
// 각 요청은 D일안에! / M만큼의 강연료 / 하루에 하나의 강연
// 최대수입

// 로직
//  페이 내림차순 // D일이하부터 max일때 들어감

import java.util.*;

class Pay implements Comparable<Pay>{
    int p;
    int d;

    public Pay(int p, int d){
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Pay o){
        return o.p - this.p;
    }
}

class Main{
    public static int sol(int n, Pay[] ps){
        int ans = 0;

        Arrays.sort(ps);
        int total_d = 0;
        for(Pay e:ps){
            total_d = Math.max(total_d, e.d);
        }

        int[] tans = new int[total_d+1];

        for(Pay e:ps){
            for(int j=e.d; j>=1; j--){
                if(e.p > tans[j]) {
                    tans[j] = e.p;
                    break;
                }
            }
        }

        for(int e:tans){
            ans += e;
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pay[] ps = new Pay[n];
        for(int i=0;i<n;i++){
            ps[i] = new Pay(sc.nextInt(), sc.nextInt());
        }

        System.out.print(sol(n, ps));
    }
}