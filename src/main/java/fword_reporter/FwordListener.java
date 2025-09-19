package fword_reporter;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class FwordListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String content = event.getMessage().getContentRaw();
        FwordSet fset = new FwordSet();
        String fword = fset.searchFword(content);

        if (!fword.isEmpty()) {
            event.getChannel().sendMessage("ブブゥーーーーーー!!!!!!!\n" + fword).queue();
        }
    }
}
