package my.consler.karma.karma.Karma;

import my.consler.karma.karma.Config;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Effects
{
    public static Map<Integer, Map<String, Map<String, Object>>> effects = Config.effects;

    public static void update(Player player, int karma, int  points_added)
    {
        AttributeInstance attribute_instance;
        NamespacedKey key;
        List<Integer> karma_levels = new ArrayList<>();
        int karma_level;
        for( Map.Entry<Integer, Map<String, Map<String, Object>>> value : effects.entrySet())
        {
            karma_level = value.getKey();
            karma_levels.add(karma_level);
            if (karma >= karma_level)
            {
                Map<String, Object> attribute_modifiers = value.getValue().get("Attribute-modifiers");
                for (String attribute_name : attribute_modifiers.keySet())
                {
                    key = NamespacedKey.minecraft(attribute_name.toLowerCase());
                    attribute_instance = player.getAttribute(
                            Objects.requireNonNull(
                                    Registry.ATTRIBUTE.get(key),
                                "Karma: unknown attribute key: " + key
                            )
                    );
                    assert attribute_instance != null; // cuz otherwise it would throw an error
                    if (attribute_modifiers.get( attribute_name).getClass() == Double.class)
                    {
                        attribute_instance.setBaseValue( (double) attribute_modifiers.get( attribute_name));
                    }
                    else if ( attribute_modifiers.get( attribute_name).getClass() == Integer.class )
                    {
                        int i = (int) attribute_modifiers.get( attribute_name);
                        attribute_instance.setBaseValue( i );
                    }
                    else
                    {
                        System.err.println("Karma: attribute value " + attribute_modifiers.get( attribute_name) + " doesn't seem to be a number");
                        throw new IllegalArgumentException();
                    }

                }

                Map<String, Object> commands = value.getValue().get("Commands");
                String command;
                int old_karma = karma - points_added;
                if (old_karma < karma_level)
                {
                    command = (String) commands.get("On-rank-up");
                    command = command.replace("@Player", player.getName());
                    player.performCommand(command);

                }
                else
                {
                    if (karma_levels.size() - 2 >= 0 && old_karma >= karma_levels.get(karma_levels.size() - 2))
                    {
                        command = (String) commands.get("On-rank-down");
                        command = command.replace("@Player", player.getName());
                        player.performCommand(command);
                    }

                }

                break;

            }

        }

    }

}
