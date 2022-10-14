import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        try{
           while(st==null || !st.hasMoreTokens()){
               st = new StringTokenizer(br.readLine());
           }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return st.nextToken();
    }
}
