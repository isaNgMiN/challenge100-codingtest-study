// 무거운게 밑에
// 넓은게 밑에
// 탑쌓기

// 가장 높이 쌓을 수 있는 탑의 높이

// 정렬 -> 최대높이 출력

import java.util.*;


class BL implements Comparable<BL> {
    int a;
    int h;
    int w;

    public BL(int a, int h, int w){
        this.a = a;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(BL o){
        if(o.a == this.a) return o.w - this.w;
        return o.a - this.a;
    }
}

class Main{

    public static int sol(int n, ArrayList<BL> bl){
        int ans = 0;

        Collections.sort(bl);
        int[] tans = new int[n];

        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(bl.get(i).w < bl.get(j).w && max < tans[j]) max = tans[j];
            }
            tans[i] = max + bl.get(i).h;
            ans = Math.max(ans, tans[i]);
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<BL> bl = new ArrayList<>();
        for(int i=0; i<n; i++){
            bl.add(new BL(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        System.out.print(sol(n, bl));

    }
}