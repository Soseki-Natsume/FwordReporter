package fword_reporter;

import java.util.List;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FwordListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String content = event.getMessage().getContentRaw();
        FwordSet fwordSet = new FwordSet();
        List<String> detectedFwords = fwordSet.searchFwords(content);
        if (!detectedFwords.isEmpty()) {
            StringBuilder response = new StringBuilder("ブブゥーーーーーー!!!!!!!\n");
            for (String fword : detectedFwords) {
                response.append(fword).append("\n");
            }
            event.getChannel().sendMessage(response.toString()).queue();
        }
    }
}
