import java.util.*;


class Pair implements Comparable<Pair>{
    int s;
    int e;

    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair o){
        if(this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }

}

class Main{

    public static int sol(int n, Pair[] p){
        int ans=0;

        Arrays.sort(p);

        int end = Integer.MIN_VALUE;
        for(Pair o:p){
            if(o.s >= end) {
                end = o.e;
                ans+=1;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] p = new Pair[n];
        for(int i=0; i<n; i++){
            p[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        System.out.print(sol(n,p));

    }
}