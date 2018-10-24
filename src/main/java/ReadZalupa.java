import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadZalupa {


    public static final String API_KEY = "5XPwGVnlanL7m4LKAnMNTJdptuKVyK8Q";

    public static void main(String[] args) {


        String url = "https://forex.1forge.com/1.0.3/quotes?pairs=USDEUR,USDRUB,AUDUSD&api_key=" + API_KEY;

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();



            JsonParser parser = new JsonParser();
            JsonElement tradeElement = parser.parse(response.toString());
            JsonArray trade = tradeElement.getAsJsonArray();


            System.out.println(trade.get(0).getAsJsonObject().get("bid"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
