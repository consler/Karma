package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EndCrystalExplosion implements Listener
{
    @EventHandler
    public void EntityDamageByEntity(EntityDamageByEntityEvent event)
    {
        if (event.getEntity() instanceof EnderCrystal && event.getDamager() instanceof Player player)
        {
            Board.add(player, Config.end_crystal_explode);
        }

    }

}
