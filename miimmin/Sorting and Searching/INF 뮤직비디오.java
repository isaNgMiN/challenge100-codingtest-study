import java.util.*;

class Main{
    public static int sol(int n, int m, int[] arr){
        int ans=-1;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt<=rt){
            int mid = (lt+rt)/2;
            int pack = 0;
            int count = 1;

            for(int i=0; i<n; i++){
                if(pack + arr[i] > mid){
                    count+=1;
                    pack = arr[i];
                }else{
                    pack+=arr[i];
                }
            }
            if(count > m) lt = mid+1;
            else if(count<=m){
                ans = mid;
                rt = mid-1;
            }

        }
        return ans;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(sol(n,m,arr));


    }
}