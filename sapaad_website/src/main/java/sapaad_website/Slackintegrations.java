package sapaad_website;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class Slackintegrations {

	private static String WebhookUrl= "https://hooks.slack.com/services/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";
	private static String Oathtoken = "xoxb-3317101527313-3304541081283-WI3g5m4nIwZQLair78hG9f9z";
	private static String slackchannel= "sapaadwebsiteautomation";
	public static void main(String[] args) {
		sendmessagetoSlack("first message awesome i am in slack with java");
	}
	public static void sendmessagetoSlack(String message) {
		try {
		StringBuilder msg = new StringBuilder();
		msg.append(message);
		Payload payload = Payload.builder().channel(slackchannel).text(msg.toString()).build();
		
		WebhookResponse webresp = Slack.getInstance().send(WebhookUrl, payload);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
