package my.consler.karma.karma.Action;

import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damaging implements Listener
{
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event)
    {
        if (event.getDamager() instanceof Player player)
        {
            if (event.getEntity() instanceof Monster)
            {
                Board.add(player.getUniqueId(), 2);
            }
            else
            {
                Board.subtract(player.getUniqueId(), 3);
            }

        }

    }

}
