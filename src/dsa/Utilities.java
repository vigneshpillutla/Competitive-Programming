package dsa;

public class Utilities {
    int mod = (int)1e9 + 7;
    long[] fact;

    public Utilities(){}
    public Utilities(int mod){
        this.mod = mod;
    }

    public static int max(int... nums){
        int res = nums[0];

        for(int i=1;i<nums.length;i++){
            res = Math.max(res,nums[i]);
        }
        return res;
    }

    public static long max(long... nums){
        long res = nums[0];

        for(int i=1;i<nums.length;i++){
            res = Math.max(res,nums[i]);
        }
        return res;
    }

    public static int min(int... nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = Math.min(res,nums[i]);
        }

        return res;
    }

    public static long min(long... nums){
        long res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = Math.min(res,nums[i]);
        }

        return res;
    }

    public static int gcd(int a,int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }

        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    public long add(long... nums){
        long res = 0;
        for(int i=0;i<nums.length;i++){
            res += (nums[i]%mod);
            res %= mod;
        }
        return res;
    }

    public long mul(long... nums){
        long res = 1;
        for(int i=0;i<nums.length;i++){
            res *= (nums[i]%mod);
            res %= mod;
        }
        return res;
    }

    public long pow_mod(long a,long b){
        long res = 1;
        while(b>0){
            if((b&1)!=0){
                res = mul(res,a);
            }
            a = mul(a,a);
            b>>=1;
        }
        return res;
    }

    public long div(long a,long b){
        long inv = pow_mod(b,mod - 2);
        return mul(a,inv);
    }


    public void genFact(int limit){
        fact = new long[limit+1];
        fact[0]=1;
        for(int i=1;i<=limit;i++){
            fact[i] = mul(i,fact[i-1]);
        }
    }
    public long ncr(int n,int r){
        if(r>n)return 0;
        long num = fact[n],den = mul(fact[r],fact[n-r]);

        return div(num,den);
    }
}
