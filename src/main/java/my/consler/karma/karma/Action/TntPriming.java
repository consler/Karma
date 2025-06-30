package my.consler.karma.karma.Action;

import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;

public class TntPriming implements Listener
{
    @EventHandler
    public void TntPrimeEvent(TNTPrimeEvent event)
    {
        if (event.getPrimingEntity() instanceof Player player)
        {
            Board.subtract(player.getUniqueId(), 100);

        }

    }

}
