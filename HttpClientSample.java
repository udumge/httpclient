import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class HttpClientSample {
  public static void main(String[] args){

    System.out.println(args[0]);
    HttpURLConnection con = null;

    try{
      URL url = new URL(args[0]);
      con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      con.connect();

      BufferedReader r = new BufferedReader(new InputStreamReader(con.getInputStream()));

      String data = "";
      while((data = r.readLine()) != null){
        System.out.println(data);
      }
      r.close();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }finally{
      con.disconnect();
    }
  }
}
