package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

public class Taming implements Listener
{
    @EventHandler
    public void entityTameEvent( EntityTameEvent event)
    {
        Board.add( (Player) event.getOwner(), Config.taming);

    }

}
