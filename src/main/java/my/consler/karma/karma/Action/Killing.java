package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.*;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.time.Instant;
import java.util.*;

public class Killing implements Listener
{
    @SuppressWarnings("unchecked")
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) //when an entity gets killed by a player
    {
        LivingEntity entity = event.getEntity();
        if( entity.getKiller() != null) // killer is always a player
        {
            Player killer = entity.getKiller();
            if ( entity instanceof Player player)
            {
                if ( Objects.requireNonNull(player.getInventory().getHelmet()).getType() == Material.AIR && Objects.requireNonNull(player.getInventory().getChestplate()).getType() == Material.AIR && Objects.requireNonNull(player.getInventory().getLeggings()).getType() == Material.AIR && Objects.requireNonNull(player.getInventory().getBoots()).getType() == Material.AIR )
                {
                    Board.add(killer, Config.naked_player_values.get("KillValue"));
                }
                else if ( respawnTimes.get(player) >= Instant.now().getEpochSecond() - Config.spawn_killed_player_values.get("RespawnRangeS") )
                {
                    Board.add(killer, Config.spawn_killed_player_values.get("KillValue"));
                }
                else
                {
                    Board.add(killer, Config.normal_player_values.get("KillValue"));
                }

            }
            else
            {
                Map<String, Integer> tmp_custom_values;
                List<String> custom_mobs = new ArrayList<>();
                for( Map.Entry<String, Object> custom_mob : Config.custom.entrySet())
                {
                    if ( custom_mob.getKey().equals( entity.getName()))
                    {
                        tmp_custom_values = (Map<String, Integer>) custom_mob.getValue();
                        Board.add(killer, (tmp_custom_values.get("KillValue")));
                        custom_mobs.add(entity.getName());

                    }

                }
                Map<String, Object> kill_values = Config.kill_values;
                if ( !custom_mobs.contains( entity.getName())) // custom values should override class values
                {
                    if ( Config.monster.contains( entity.getName()))
                    {
                        Board.add(killer, (Integer) kill_values.get("Monster"));

                    }
                    else if ( Config.friend.contains( entity.getName()))
                    {
                        Board.add(killer, (Integer) kill_values.get("Friendly"));

                    }
                    else if ( Config.neuter.contains( entity.getName()))
                    {
                        Board.add(killer, (Integer) kill_values.get("Neuter"));
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
