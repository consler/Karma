package my.consler.karma.karma.Karma.Command;

import my.consler.karma.karma.Karma.Board;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetKarma implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args)
    {
        if (sender instanceof Player player)
        {

            if(NumberUtils.isCreatable( args[0]))
            {
                Board.set(player.getUniqueId(), Integer.parseInt( args[0]));

            }
            else
            {
                Board.set( Bukkit.getPlayerUniqueId( args[0]), Integer.parseInt( args[1]));

            }


        }

        return true;

    }
}
