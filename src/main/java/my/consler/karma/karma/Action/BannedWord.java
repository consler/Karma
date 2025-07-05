package my.consler.karma.karma.Action;

import io.papermc.paper.event.player.AsyncChatEvent;
import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BannedWord implements Listener
{
    @EventHandler
    public static void AsyncChatEvent(AsyncChatEvent event)
    {
        for(String word : Config.banned_words)
        {
            if ( event.message().toString().toLowerCase().contains(word.toLowerCase()))
            {
                Board.add(event.getPlayer(), Config.type_banned_word);
            }

        }

    }

}
