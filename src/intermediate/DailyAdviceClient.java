package intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    public void go(){
        try{
            Socket socket = new Socket("127.0.0.1", 9000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Today you shouild: " + advice);
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String... args){
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
