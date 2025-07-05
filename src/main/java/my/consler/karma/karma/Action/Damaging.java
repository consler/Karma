package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.time.Instant;
import java.util.*;

public class Damaging implements Listener
{
    @SuppressWarnings("unchecked")
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event)
    {
        Entity entity = event.getEntity();
        if (event.getDamager() instanceof Player damager)
        {
            if (entity instanceof Player player)
            {
                if ( player.getInventory().getHelmet().getType() == Material.AIR && player.getInventory().getChestplate().getType() == Material.AIR && player.getInventory().getLeggings().getType() == Material.AIR && player.getInventory().getBoots().getType() == Material.AIR )
                {
                    Board.add(damager, Config.naked_player_values.get("DamageValue"));
                }
                else if ( respawnTimes.get(player) >= Instant.now().getEpochSecond() - Config.spawn_killed_player_values.get("RespawnRangeS") )
                {
                    Board.add(damager, Config.spawn_killed_player_values.get("DamageValue"));
                }
                else
                {
                    Board.add(damager, Config.normal_player_values.get("DamageValue"));
                }

            }
            else
            {
                Map<String, Integer> tmp_custom_values;
                List<String> custom_mobs = new ArrayList<>();

                for(Map.Entry<String, Object> custom_mob : Config.custom.entrySet())
                {
                    if ( custom_mob.getKey().equals( entity.getName()))
                    {
                        tmp_custom_values = (Map<String, Integer>) custom_mob.getValue();
                        Board.add(damager, (tmp_custom_values.get("DamageValue")));
                        custom_mobs.add(entity.getName());

                    }

                }

                Map<String, Object> damage_values = Config.damage_values;

                if ( !custom_mobs.contains( entity.getName())) // custom values should override class values
                {
                    if ( Config.monster.contains( entity.getName()))
                    {
                        Board.add(damager, (Integer) damage_values.get("Monster"));

                    }
                    else if ( Config.friend.contains( entity.getName()))
                    {
                        Board.add(damager, (Integer) damage_values.get("Friendly"));

                    }
                    else if ( Config.neuter.contains( entity.getName()))
                    {
                        Board.add(damager, (Integer) damage_values.get("Neuter"));
                    }

                }

            }

        }

    }

    public static Map<Player, Integer> respawnTimes = new HashMap<>();

    @EventHandler
    public static void PlayerRespawnEvent(PlayerRespawnEvent event)
    {
        respawnTimes.put(event.getPlayer(), Math.toIntExact( Instant.now().getEpochSecond()));
    }

}
