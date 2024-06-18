package utils;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import config.Config;

public class SlackIntegration {
    private static final String WEBHOOK_URL = Config.get("slack.webhook.url");

    public static void sendMessage(String message) {
        try {
            Payload payload = Payload.builder().text(message).build();
            WebhookResponse response = Slack.getInstance().send(WEBHOOK_URL, payload);
            System.out.println("Slack response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

