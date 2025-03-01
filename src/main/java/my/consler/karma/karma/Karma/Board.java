package my.consler.karma.karma.Karma;

import my.consler.karma.karma.SaveSystem;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Board {
    public static HashMap<UUID, Integer> karma_board = new HashMap<>(); // main list with everyone's karma

    public static void load()
    {
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
            SaveSystem.writeto_savefile(karma_board);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);

        }
    }

    public static void set(UUID uuid, int points) // setting one's points
    {
        karma_board.put(uuid, points);
        onUpdate(uuid);

    }

    public static void add( UUID uuid, int points) // adding points to one's aura
    {
        karma_board.put( uuid, karma_board.get(uuid) + points);
        onUpdate(uuid);

    }

    public static void subtract(UUID uuid, int points) // subtracting points from one's aura
    {
        karma_board.put(uuid, karma_board.get(uuid) - points);
        onUpdate(uuid);

    }

    public static int get(UUID uuid) // retrieving one's points
    {
        return karma_board.get(uuid);

    }

    public static void onUpdate(UUID uuid) // gets called every time something changes in the board
    {
        OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(uuid);
        if( offlineplayer.isOnline())
        {
            Player player = offlineplayer.getPlayer();
            int karma = karma_board.get(uuid);
            assert player != null;
            Effects.update(player, karma);

        }

    }

}
