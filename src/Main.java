import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String param = "name";
        String paramValue = "toronto";
        URL url = new URL("https://api.api-ninjas.com/v1/city" + "?" + param + "=" + paramValue);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        String header = "X-Api-Key";
        String headerValue = "oR3xqD6tjXLUiFvgGcbulraYxWZH4JByHqYSOiNE";
        con.setRequestProperty(header, headerValue);

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader reader;
        if (responseCode >= 200 && responseCode < 300) {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        System.out.println("Error response: " + response.toString());
    }
}
