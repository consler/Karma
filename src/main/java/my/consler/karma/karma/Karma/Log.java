package my.consler.karma.karma.Karma;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Log
{

    public static void create()
    {
        new File("plugins/Karma/").mkdirs();
        File logfile = new File("plugins/Karma/karma.log");
        try
        {
            if (!logfile.exists())
            {
                logfile.createNewFile();
            }
            System.out.println("Log file created: " + logfile.getPath());


        }
        catch (IOException e)
        {
            throw new RuntimeException(e);

        }

    }

    static File logfile = new File("plugins/Karma/karma.log");

    public static void add(Player player, int value)
    {
        try
        {
            String s = player.getName() + " (" + player.getUniqueId() + ") just got " + value + " karma. Now their karma is " + Board.get(player) + "\n";
            Files.write(logfile.toPath(), s.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    public static void setkarma(Player player, Player sender, int value)
    {
        try
        {
            String s = player.getName() + " (" + player.getUniqueId() + ") just set +" + sender.getName() + "'s (" + sender.getUniqueId() + ") karma to "+  value + "\n";
            Files.write(logfile.toPath(), s.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    public static void thank(Player player, OfflinePlayer sender, int value)
    {
        try
        {
            String s = player.getName() + " (" + player.getUniqueId() + ") just thanked " + sender.getName() + "'s (" + sender.getUniqueId() + ") with "+  value + " karma \n";
            Files.write(logfile.toPath(), s.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

}
