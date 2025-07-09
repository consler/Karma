package my.consler.karma.karma.Action;

import my.consler.karma.karma.Config;
import my.consler.karma.karma.Karma.Board;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;

import java.util.UUID;

public class Raid implements Listener
{
    @EventHandler
    public void RaidTriggerEvent(RaidTriggerEvent event)
    {
        Board.add(event.getPlayer(), Config.starting_raid);

    }


    @EventHandler
    public void RaidStopEvent(RaidStopEvent event)
    {
//        System.out.println("stop");
//        System.out.println(event.getRaid().getHeroes());
        if (event.getReason() == RaidStopEvent.Reason.FINISHED)
        {
            for (UUID hero : event.getRaid().getHeroes())
            {
//                System.out.println("win");
                Board.add(Bukkit.getPlayer(hero), Config.ending_raid);

            }

        }

    }

}
