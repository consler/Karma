package my.consler.karma.karma.Karma;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.SaveSystem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Board
{
    public static Timestamp last_addition;

    public static HashMap<UUID, Integer> karma_board = new HashMap<>(); // main list with everyone's karma

    public static void load()
    {
        if( last_addition == null) last_addition = Timestamp.from(Instant.now());

        try
        {
            karma_board = SaveSystem.read_savefile();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);

        }

    }

    public static void save()
    {
        try
        {
            SaveSystem.write_to_savefile(karma_board);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);

        }
    }

    public static void set(Player player, int points) // setting one's points
    {
        karma_board.put(player.getUniqueId(), points);
        onUpdate(player, points - Board.get(player));

    }

    public static void add(Player player, int points) // adding points to one's karma
    {
        if (points > 0)
        {
            if( Objects.requireNonNull(last_addition).before( Timestamp.from( Instant.now().minusMillis(Config.earn_karma_delay))))
            {
                last_addition = Timestamp.from( Instant.now());
                karma_board.put( player.getUniqueId(), karma_board.get(player.getUniqueId()) + points);
                onUpdate(player, points);

                player.sendActionBar(Component.text("Received " + points + " karma points", NamedTextColor.GREEN));
                Log.add(player,  points);

            }

        }
        else if (points < 0)
        {
            if( Objects.requireNonNull(last_addition).before( Timestamp.from( Instant.now().minusMillis(Config.lose_karma_delay))))
            {
                karma_board.put( player.getUniqueId(), karma_board.get(player.getUniqueId()) + points);
                onUpdate(player, points);

                player.sendActionBar(Component.text("Taken away " + -points + " karma points", NamedTextColor.RED));

                Log.add(player,  points);

            }

        }

    }

    public static int get(Player player) // retrieving one's points
    {
        return karma_board.get(player.getUniqueId());

    }

    public static void onUpdate(Player player, int points_added) // gets called every time something changes in the board
    {
        OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(player.getUniqueId());
        if( offlineplayer.isOnline())
        {
            int karma = karma_board.get(player.getUniqueId());
            Effects.update(player, karma, points_added);

        }

    }

}
