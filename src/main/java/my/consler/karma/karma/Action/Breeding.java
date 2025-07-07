package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class Breeding implements Listener
{
    @EventHandler
    public void EntityBreedEvent(EntityBreedEvent event)
    {
        if (event.getBreeder() instanceof Player player)
        {
            Board.add(player, Config.breeding);
        }

    }

}
