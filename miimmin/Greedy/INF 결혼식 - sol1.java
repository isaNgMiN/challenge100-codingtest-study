// 친구들의 도착시간 - 떠난시간
// 피로연 장소에 동시에 존재하는 최대인원수 출력
// 도착시간 == 존재 / 떠난시간 == XX / 도착시간과 떠난시간은 같을 수 없다
// 시간프레임 0~72

// 로직
//  start 오름차순
//  모인수 ArrayList
//  start 와 end 저장 / 그안에 들어오면 +1 / 빠져나가면 -1

import java.util.*;

//frequency
class Time implements Comparable<Time>{
    int s;
    int e;
    public Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        return this.s - o.s;
    }
}


class Main{
    public static int sol(int n, ArrayList<Integer> s, ArrayList<Integer> e, Time[] t){
        int ans=0;

        Arrays.sort(t);
//        Collections.sort(s);
//        Collections.sort(e);

        for(int i=0; i<n; i++){
//            System.out.println(s.get(i) + " " + e.get(i));
//            System.out.println(t[i].s + " " + t[i].e);
            s.add(t[i].s);
            e.add(t[i].e);
        }

        ArrayList<Integer> end = new ArrayList<>();
        int tmp = 0;
        for(Integer i=0; i<72; i++){
            if(s.contains(i)) {
                tmp += Collections.frequency(s, i);
            }
            if(e.contains(i)){
                tmp -= Collections.frequency(e, i);
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Time[] t = new Time[n];
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        for(int i=0; i<n;i++){
//            s.add(sc.nextInt());
//            e.add(sc.nextInt());
            t[i] = new Time(sc.nextInt(), sc.nextInt());
        }

        System.out.print(sol(n,s,e,t));

    }
}