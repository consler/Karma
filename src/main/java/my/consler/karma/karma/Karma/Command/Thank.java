package my.consler.karma.karma.Karma.Command;

import my.consler.karma.karma.Karma.Board;
import my.consler.karma.karma.Karma.Log;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Thank implements CommandExecutor
{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args)
    {
        if (sender instanceof Player)
        {
            if (args.length == 2)
            {
                if (NumberUtils.isCreatable(args[1]))
                {
                    OfflinePlayer receiver = Bukkit.getOfflinePlayerIfCached(args[0]);
                    int karma_sent = Integer.parseInt(args[1]);
                    if (receiver != null)
                    {
                        if (Board.karma_board.containsKey(receiver.getUniqueId()))
                        {
                            if(karma_sent > 0 && Board.get( (Player) sender) - karma_sent >= 0)
                            {
                                Board.add( (Player) sender, -karma_sent);
                                Board.add( (Player) receiver, karma_sent);
                                sender.sendMessage("You thanked " + args[0] + " with " + args[1] + " karma!");
                                if(receiver.isOnline())
                                {
                                    Objects.requireNonNull( receiver.getPlayer()).sendMessage("You received " + args[1] + " karma from " + sender.getName());
                                    Log.thank((Player) sender, receiver, karma_sent);

                                }

                            }
                            else
                            {
                                sender.sendMessage("§CCan't send the specified amount of karma");

                            }

                        }
                        else
                        {
                            sender.sendMessage("§CInvalid receiver!");

                        }

                    }
                    else
                    {
                        sender.sendMessage("§CInvalid receiver!");

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

        return true;
    }

}
