import java.util.*;


class Click implements Comparable<Click>{
    char status;
    int time;

    public Click(char status,int time){
        this.status = status;
        this.time = time;
    }

    @Override
    public int compareTo(Click o){
        if(this.time == o.time) return this.status - o.status;
        return this.time - o.time;
    }
}

class Main{

    public static int sol(int n, Click[] c){
        int ans = 0;
        Arrays.sort(c);

        int tmp=0;
        for(Click e:c){
            if(e.status == 'e'){
                 tmp-=1;
            }
            else{
                tmp+=1;
            }
            ans = Math.max(ans,tmp);
//            System.out.println(e.status + " " + e.time + " " + tmp);
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Click[] c = new Click[2*n];
        for(int i=0; i<2*n; i++){
            if(i%2 == 0) c[i] = new Click('s', sc.nextInt());
            else c[i] = new Click('e', sc.nextInt());
        }

        System.out.print(sol(n,c));
    }
}