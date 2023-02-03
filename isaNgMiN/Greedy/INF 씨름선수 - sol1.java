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
    public int compareTo(Ps e){
        if(h == e.h) return w - e.w;
        else return h - e.h;
    }
}

class Main{

    public static int sol(int n, Ps[] ps){
        int ans = n;
        Arrays.sort(ps);

        for(int i=0; i<n-1; i++){
            if(ps[i].h == ps[i+1].h) continue;
            for(int j=i+1; j<n; j++){
                if(ps[i].w < ps[j].w) {
                    ans-=1;
                    break;
                }
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