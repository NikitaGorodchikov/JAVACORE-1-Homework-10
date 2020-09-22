import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Main {
    public static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=8XrtNEVrilZgFZu6NACFvxQuT2AfANAXvh3xJfLh");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            Fact fact =  mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
            System.out.println(fact.toString());

            String url = fact.getUrl();

            String[] urlSplit = url.split("/");
            String name = urlSplit[urlSplit.length-1];

            URL urlForDl = new URL(url);
            BufferedImage img = ImageIO.read(urlForDl);
            File file = new File(name);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
