package my.consler.karma.karma.Karma.Command;

import my.consler.karma.karma.Karma.Board;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckKarma implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args)
    {
        if (sender instanceof Player player)
        {
            if(args.length == 1)
            {
                player.sendMessage(args[0] + "'s karma is " + Board.get( Bukkit.getPlayerUniqueId(args[0])));

            }
            else if (args.length == 0)
            {
                player.sendMessage("Your karma is " + Board.get( player.getUniqueId()));

            }
            else
            {
                player.sendMessage("Too many arguments!");
            }

        }

        return true;

    }

}
