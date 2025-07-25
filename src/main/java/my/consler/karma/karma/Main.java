package my.consler.karma.karma;

import my.consler.karma.karma.Action.*;
import my.consler.karma.karma.Karma.Board;
import my.consler.karma.karma.Karma.Command.CheckKarma;
import my.consler.karma.karma.Karma.Command.Leaderboard;
import my.consler.karma.karma.Karma.Command.SetKarma;
import my.consler.karma.karma.Karma.Command.Thank;
import my.consler.karma.karma.Karma.Log;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Instant;
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
        Bukkit.getPluginManager().registerEvents(new TntPriming(), this);
        Bukkit.getPluginManager().registerEvents(new EndCrystalExplosion(), this);
        Bukkit.getPluginManager().registerEvents(new BannedWord(), this);
        Bukkit.getPluginManager().registerEvents(new CollectingFlowers(), this);
        Bukkit.getPluginManager().registerEvents(new Animal_feeding(), this);
        Bukkit.getPluginManager().registerEvents(new Taming(), this);
        Bukkit.getPluginManager().registerEvents(new Raid(), this);

        Objects.requireNonNull( this.getCommand("checkKarma")).setExecutor( new CheckKarma()); // adding commands
        Objects.requireNonNull( this.getCommand("setKarma")).setExecutor( new SetKarma());
        Objects.requireNonNull( this.getCommand("thank")).setExecutor( new Thank());
        Objects.requireNonNull( this.getCommand("leaderboard")).setExecutor( new Leaderboard());

        Log.create();
        Board.load();

    }

    @Override
    public void onDisable()
    {
        Board.save();

    }

    @EventHandler
    public void WorldSaveEvent(WorldSaveEvent event)
    {
        Board.save();

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if( !( Board.karma_board.containsKey( player.getUniqueId()))) // add uuid to the list of karmas
        {
            Board.set(player, 0);

        }
        Board.onUpdate(player, 0);
        Killing.respawnTimes.put(player, Math.toIntExact( Instant.now().getEpochSecond()));
        Damaging.respawnTimes.put(player, Math.toIntExact( Instant.now().getEpochSecond()));

    }

}
