package my.consler.karma.karma;

import my.consler.karma.karma.Action.*;
import my.consler.karma.karma.Karma.Board;
import my.consler.karma.karma.Karma.Command.CheckKarma;
import my.consler.karma.karma.Karma.Command.SetKarma;
import my.consler.karma.karma.Karma.Command.Thank;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.UUID;

public final class Main extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(this, this); //registering listeners
        Bukkit.getPluginManager().registerEvents(new Killing(), this);
        Bukkit.getPluginManager().registerEvents(new Damaging(), this);
        Bukkit.getPluginManager().registerEvents(new Advancement(), this);
        Bukkit.getPluginManager().registerEvents(new TntPriming(), this);
        Bukkit.getPluginManager().registerEvents(new EndCrystalExplosion(), this);

        Objects.requireNonNull( this.getCommand("checkKarma")).setExecutor( new CheckKarma()); // adding commands
        Objects.requireNonNull( this.getCommand("setKarma")).setExecutor( new SetKarma());
        Objects.requireNonNull( this.getCommand("thank")).setExecutor( new Thank());

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
        UUID playerUUID = event.getPlayer().getUniqueId();
        if( !( Board.karma_board.containsKey( playerUUID))) // add uuid to the list of karmas
        {
            Board.karma_board.put(playerUUID, 0);

        }
        Board.onUpdate(playerUUID);

    }

}
