package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Damaging implements Listener
{
    @SuppressWarnings("unchecked")
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event)
    {
        Entity entity = event.getEntity();
        if (event.getDamager() instanceof Player player)
        {
            Map<String, Integer> tmp_custom_values;
            List<String> custom_mobs = new ArrayList<>();

            for(Map.Entry<String, Object> custom_mob : Config.custom.entrySet())
            {
                if ( custom_mob.getKey().equals( entity.getName()))
                {
                    tmp_custom_values = (Map<String, Integer>) custom_mob.getValue();
                    Board.add(player, (tmp_custom_values.get("DamageValue")));
                    custom_mobs.add(entity.getName());

                }

            }

            Map<String, Object> damage_values = Config.damage_values;

            if ( !custom_mobs.contains( entity.getName())) // custom values should override class values
            {
                if ( Config.monster.contains( entity.getName()))
                {
                    Board.add(player, (Integer) damage_values.get("Monster"));

                }
                else if ( Config.friend.contains( entity.getName()))
                {
                    Board.add(player, (Integer) damage_values.get("Friendly"));

                }
                else if ( Config.neuter.contains( entity.getName()))
                {
                    Board.add(player, (Integer) damage_values.get("Neuter"));
                }
                else if(entity instanceof Player)
                {
                    Board.add(player, -500);
                }

            }

        }

    }

}
