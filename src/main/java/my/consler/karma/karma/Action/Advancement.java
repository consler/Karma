package my.consler.karma.karma.Action;

import io.papermc.paper.advancement.AdvancementDisplay;
import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class Advancement implements Listener
{
    @EventHandler
    public void PlayerAdvancementDoneEvent(PlayerAdvancementDoneEvent event)
    {
        AdvancementDisplay display = event.getAdvancement().getDisplay();
        if (display != null && display.frame() == AdvancementDisplay.Frame.CHALLENGE)
        {
            Board.add(event.getPlayer(), Config.challenge);

        }
        else if (display != null)
        {
            Board.add(event.getPlayer(), Config.advancement);

        }

    }

}
