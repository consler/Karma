package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.*;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Killing implements Listener
{
    @SuppressWarnings("unchecked")
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) //when an entity gets killed by a player
    {
        LivingEntity entity = event.getEntity();
        if(entity.getKiller() != null) // killer is always a player
        {
            Player player = entity.getKiller();

            Map<String, Integer> tmp_custom_values;
            List<String> custom_mobs = new ArrayList<>();

            for(Map.Entry<String, Object> custom_mob : Config.custom.entrySet())
            {
                if ( custom_mob.getKey().equals( entity.getName()))
                {
                    tmp_custom_values = (Map<String, Integer>) custom_mob.getValue();
                    Board.add(player, (tmp_custom_values.get("KillValue")));
                    custom_mobs.add(entity.getName());

                }

            }

            Map<String, Object> kill_values = Config.kill_values;
            if ( !custom_mobs.contains( entity.getName())) // custom values should override class values
            {
                if ( Config.monster.contains( entity.getName()))
                {
                    Board.add(player, (Integer) kill_values.get("Monster"));

                }
                else if ( Config.friend.contains( entity.getName()))
                {
                    Board.add(player, (Integer) kill_values.get("Friendly"));

                }
                else if ( Config.neuter.contains( entity.getName()))
                {
                    Board.add(player, (Integer) kill_values.get("Neuter"));
                }

            }

        }

    }

}
