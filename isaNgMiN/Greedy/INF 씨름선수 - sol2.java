// A보다 키와 몸무게 모두 이기는게 있으면 탈락
// 걸러지고 남은 인원출력

// 로직. X 정렬후 Y로 비교

import java.util.*;

class Ps implements Comparable<Ps>{
    int h;
    int w;
    public Ps(int h, int w){
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Ps o){
        if(h == o.h) return o.w - this.w;
        else return o.h - this.h;
    }
}

class Main{

    public static int sol(int n, Ps[] ps){
        int ans = 0;
        Arrays.sort(ps);


        int max = Integer.MIN_VALUE;
        for(Ps e:ps){
            System.out.println(e.h + " " + e.w);
            if(e.w > max){
                max = e.w;
                ans+=1;
            }

        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ps[] ps = new Ps[n];
        for(int i=0; i<n; i++){
            ps[i] = new Ps(sc.nextInt(), sc.nextInt());
        }

        System.out.print(sol(n,ps));
    }
}