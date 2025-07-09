package my.consler.karma.karma.Karma.Command;

import my.consler.karma.karma.Karma.Board;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Leaderboard implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args)
    {
        if ( args.length == 0 )
        {
            Map<String, Integer> leaderboard = new HashMap<>();
            for (Map.Entry<UUID, Integer> entry : Board.karma_board.entrySet())
            {
                leaderboard.put(Bukkit.getOfflinePlayer( entry.getKey()).getName(), entry.getValue());


            }

            String output = leaderboard.toString().replaceAll(",", "\n");
            output = output.substring(1, output.length() - 1).replaceAll("=", ": ");
            sender.sendMessage(output);

            return true;

        }
        else
        {
            return false;
        }

    }

}
