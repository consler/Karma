package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.entity.Animals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Animal_feeding implements Listener
{
    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
    {
        if (event.getRightClicked() instanceof Animals && ((Animals) event.getRightClicked()).isBreedItem(event.getPlayer().getInventory().getItemInMainHand()))
        {
            Board.add(event.getPlayer(), Config.animal_feeding);

        }

    }

}
