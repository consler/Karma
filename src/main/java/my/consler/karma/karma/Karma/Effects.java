package my.consler.karma.karma.Karma;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class Effects
{

    public static void update(Player player, int karma)
    {
        AttributeInstance attackDamage = player.getAttribute(Attribute.ATTACK_DAMAGE);
        assert attackDamage != null;

        if (karma > 2500)
        {
            attackDamage.setBaseValue(7);

        }
        else if (karma > 1000)
        {
            attackDamage.setBaseValue(4);

        }
        else if (karma > 200)
        {
            attackDamage.setBaseValue(2);

        }
        else if (karma < -2500)
        {
            attackDamage.setBaseValue(-6);

        }
        else if (karma < -1000)
        {
            attackDamage.setBaseValue(-3);

        }
        else if (karma < -200)
        {
            attackDamage.setBaseValue(1);

        }

    }

}
