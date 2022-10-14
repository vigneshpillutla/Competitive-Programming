import java.io.*;
import java.util.*;

public class Main {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()  {
            try{
                while(st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st!=null && st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){return Long.parseLong(next()); }

        double nextDouble(){return Double.parseDouble(next()); }

        int[] readIntArray(int size){
            int[] arr = new int[size];
            for(int i=0;i<size;i++){
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] readLongArray(int size){
            long[] arr = new long[size];
            for(int i=0;i<size;i++){
                arr[i] = nextLong();
            }
            return arr;
        }
    }
    static class Utilities {
        int mod = (int)1e9 + 7;

        public Utilities(){}
        public Utilities(int mod){
            this.mod = mod;
        }

        public int add(int a,int b){
            return ((a%mod)+(b%mod))%mod;
        }

        public int mul(int a,int b){
            long res = a%mod;
            res *= (b%mod);
            return (int)(res%mod);
        }

        public int pow_mod(int a,int b){
            int res = 1;
            while(b>0){
                if((b&1)!=0){
                    res = mul(res,a);
                }
                a = mul(a,a);
                b>>=1;
            }
            return res;
        }

        public int div(int a,int b){
            int inv = pow_mod(b,mod - 2);
            return mul(a,inv);
        }

        public int max(int... nums){
            int res = nums[0];

            for(int i=1;i<nums.length;i++){
                res = Math.max(res,nums[i]);
            }
            return res;
        }

        public long max(long... nums){
            long res = nums[0];

            for(int i=1;i<nums.length;i++){
                res = Math.max(res,nums[i]);
            }
            return res;
        }

        public int min(int... nums){
            int res = nums[0];
            for(int i=1;i<nums.length;i++){
                res = Math.min(res,nums[i]);
            }

            return res;
        }

        public long min(long... nums){
            long res = nums[0];
            for(int i=1;i<nums.length;i++){
                res = Math.min(res,nums[i]);
            }

            return res;
        }
    }
    static long mod = 998244353;
    static int n;
    static long[][][] dp;
    static long add(long a,long b){
        return ((a%mod)+(b%mod))%mod;
    }

    static long mul(long a,long b){
        return ((a%mod)*(b%mod))%mod;
    }

    static boolean isActivated(int mask,int pos){
        return (mask&(1<<pos))!=0;
    }

    static long rec(int prev,int mask,int idx){
        if(idx==n){
            return 1;
        }

        if(dp[idx][prev][mask]!=0)return dp[idx][prev][mask];

        long ans = 0;

        for(int i=0;i<5;i++){
            if(!(prev!=i && isActivated(mask,i))){
                ans = add(ans,rec(i,mask|(1<<i),idx+1));
            }
        }
        long consonants = rec(prev,mask,idx+1);
        ans = add(ans,mul(21,consonants));

        return dp[idx][prev][mask] = ans;
    }

    public static void main(String[] args)throws IOException {
        FastReader reader = new FastReader();
//        Utilities util = new Utilities(998244353);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = reader.nextInt();
        long a,b;
//        int t = 1;
        while(t-->0){
           Main.n = reader.nextInt();
           dp = new long[n+1][7][32];
           for(int i=0;i<7;i++){
               for(int j=0;j<32;j++){
                   dp[n][i][j] = 1;
               }
           }

           for(int i = n-1;i>=0;i--){
               for(int p=0;p<7;p++){
                   for(int mask=0;mask<32;mask++){
                       for(int curr=0;curr<5;curr++){
                           if(!(p!=i && isActivated(mask,i))){
                               a = dp[i][p][mask];
                               b = dp[i+1][curr][mask|(1<<curr)];
                               dp[i][p][mask] = ((a%mod) + (b%mod))%mod;
                           }
                       }
//                        long consonants = (dp[i+1][p][mask]*21)%mod;
//                       a = dp[i][p][mask];
//                       dp[i][p][mask] = ((a%mod) + (consonants%mod))%mod;
                       dp[i][p][mask] = add(dp[i][p][mask],mul(21,dp[i+1][p][mask]));
                   }
               }
           }
            long ans = dp[0][6][0];
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}

