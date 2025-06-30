package my.consler.karma.karma.Action;

import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;
import java.util.UUID;

public class Damaging implements Listener
{
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event)
    {
        if (event.getDamager() instanceof Player player)
        {
            UUID player_uuid = Objects.requireNonNull( player.getUniqueId());
            if(event.getEntity() instanceof Player)
            {
                Board.subtract(player_uuid, 50);

            }
            else if ( ! (event.getEntity() instanceof Monster))
            {
                Board.subtract(player_uuid, 1);

            }

        }

    }

}
