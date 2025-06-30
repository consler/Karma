package my.consler.karma.karma.Action;

import my.consler.karma.karma.Karma.*;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Objects;
import java.util.UUID;

public class Killing implements Listener
{
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) //when an entity gets killed by a player
    {
        LivingEntity entity = event.getEntity();
        if(entity.getKiller() != null)
        {
            UUID player_uuid = Objects.requireNonNull( entity.getKiller().getUniqueId());
            if (entity instanceof Monster)
            {
                Board.add(player_uuid, 1);

            }
            else if(entity instanceof Player)
            {
                Board.subtract(player_uuid, 500);
            }
            else
            {
                Board.subtract(player_uuid, 15);

            }

        }

    }

}
