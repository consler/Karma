package my.consler.karma.karma;

import my.consler.karma.karma.Action.Advancement;
import my.consler.karma.karma.Action.Damaging;
import my.consler.karma.karma.Action.Killing;
import my.consler.karma.karma.Karma.Board;
import my.consler.karma.karma.Karma.Command.CheckKarma;
import my.consler.karma.karma.Karma.Command.SetKarma;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(this, this); //registering listeners
        Bukkit.getPluginManager().registerEvents(new Killing(), this);
        Bukkit.getPluginManager().registerEvents(new Damaging(), this);
        Bukkit.getPluginManager().registerEvents(new Advancement(), this);

        Objects.requireNonNull( this.getCommand("checkKarma")).setExecutor( new CheckKarma()); // adding commands
        Objects.requireNonNull( this.getCommand("setKarma")).setExecutor( new SetKarma());

        Board.load();

    }

    @Override
    public void onDisable()
    {
        Board.save();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if( !( Board.karma_board.containsKey( event.getPlayer().getUniqueId()))) // add uuid to the list of karmas
        {
            Board.karma_board.put( event.getPlayer().getUniqueId(), 0);

        }

    }
}
