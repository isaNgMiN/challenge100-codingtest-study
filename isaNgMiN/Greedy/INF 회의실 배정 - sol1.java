// 1개의 회의실에 N개의 회의배정
//  회의가 겹치지 않게, 회의실 사용할 수 있는 최대수
//  시작시간 < 끝나는 시간 / 시작시간 = 끝나는 시간

//로직
//  for문 돌되, 이전의 끝난시간 + 지금 끝나는 시간이 더 짧으면 업데이트

import java.util.*;

class Time implements Comparable<Time>{
    int s;
    int e;
    public Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        if(this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }

}

class Main{

    public static int sol(int n, Time[] t){
        int ans=1;
        Arrays.sort(t);


        ArrayList<Time> sch = new ArrayList<>();
        int start = t[0].s;
        int end = t[0].e;
        for(int i=0; i<n; i++){
            if(t[i].e < end && t[i].s >= start){
                end = t[i].e;
                start=t[i].s;
            }
            else if(t[i].s >= end){
                end = t[i].e;
                start=t[i].s;
                ans+=1;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Time[] t = new Time[n];
        for(int i=0; i<n; i++){
            t[i] = new Time(sc.nextInt(), sc.nextInt());
        }

        System.out.print(sol(n,t));

    }
}