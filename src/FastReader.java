import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader{
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
