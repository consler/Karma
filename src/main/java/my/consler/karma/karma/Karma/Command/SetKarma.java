package my.consler.karma.karma.Karma.Command;

import my.consler.karma.karma.Karma.Board;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetKarma implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args)
    {
        if (sender instanceof Player player)
        {
            if (args.length == 1)
            {
                if(NumberUtils.isCreatable( args[0]))
                {
                    Board.set(player, Integer.parseInt( args[0]));
                    player.sendMessage("Set " + player.getName() + "'s karma to " + args[0]);

                }

            }
            else if (args.length == 2)
            {
                OfflinePlayer offlineplayer = Bukkit.getOfflinePlayerIfCached( args[0]);
                if(offlineplayer != null)
                {
                    if (NumberUtils.isCreatable(args[1]))
                    {
                        if (Board.karma_board.containsKey( offlineplayer.getUniqueId()))
                        {
                            Board.set( Objects.requireNonNull( offlineplayer.getPlayer()), Integer.parseInt(args[1]));
                            player.sendMessage("Set " + args[0] + "'s karma to " + args[1]);

                        }
                        else
                        {
                            player.sendMessage("§CCouldn't find " + args[0]);

                        }

                    }
                    else
                    {
                        return false;

                    }

                }
                else
                {
                    return false;
                }

            }
            else
            {
                player.sendMessage("Incorrect usage. Correct usage: /setkarma <amountOfPoints> or /setkarma <player> <amountOfPoints>");
            }

        }

        return true;

    }
}
