package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import my.consler.karma.karma.Main;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class CollectingFlowers implements Listener
{
    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event)
    {
        if (Tag.FLOWERS.isTagged( event.getBlock().getType()))
        {
            event.getBlock().setMetadata("NOT_NATTY", new FixedMetadataValue( Main.getPlugin( Main.class), "true"));

        }

    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event)
    {
        Block block = event.getBlock();
        if ( Tag.FLOWERS.isTagged( block.getType()) && !block.getType().equals( Material.WILDFLOWERS) && block.getMetadata("NOT_NATTY").isEmpty())
        {
            Board.add(event.getPlayer(), Config.collect_flower);

        }

    }

}
