package utils;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import config.Config;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackIntegration {
    public static void sendNotification(String message) {
        try {
            String payload = "{\"text\":\"" + message + "\"}";
            URL url = new URL("https://hooks.slack.com/services/your/slack/webhook/url");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(payload.getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}