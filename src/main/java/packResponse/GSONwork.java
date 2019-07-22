package packResponse;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GSONwork {
    private static final Gson GSON = new Gson();

    public List<Any> loadURLbyStream(String requestURL) {
        List<Any> nbPresponse = null;

        try {
            URL url = new URL(requestURL);
            InputStream inputStream = url.openStream();
            nbPresponse = GSON.fromJson(new InputStreamReader(inputStream), List.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nbPresponse;
    }

    public List<Any> loadURLbyString(String requestURL) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL url = new URL(requestURL);
            InputStream inputStream = url.openStream();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                bufferedReader.lines().forEach(stringBuilder::append);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Any> nbPresponse = GSON.fromJson(stringBuilder.toString(), List.class);
        return nbPresponse;
    }
}
