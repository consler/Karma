package my.consler.karma.karma.Action;

import io.papermc.paper.advancement.AdvancementDisplay;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Advancement implements Listener
{
    @EventHandler
    public void PlayerAdvancementDoneEvent(PlayerAdvancementDoneEvent event)
    {
        org.bukkit.advancement.@NotNull Advancement advancement = event.getAdvancement();
        AdvancementDisplay display = advancement.getDisplay();
        if (display != null)
        {
            if (AdvancementDisplay.Frame.CHALLENGE.equals( Objects.requireNonNull( display.frame())))
            {
                Board.add(event.getPlayer().getUniqueId(), 500);

            }
            else
            {
                Board.add(event.getPlayer().getUniqueId(), 50);

            }

        }

    }

}
