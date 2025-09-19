package fword_reporter;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class FwordMain {
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");

        JDABuilder.createDefault(token)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(new FwordListener())
            .build();
    }
}
