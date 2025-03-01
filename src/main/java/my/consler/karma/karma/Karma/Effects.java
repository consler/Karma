package my.consler.karma.karma.Karma;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class Effects
{

    public static void update(Player player, int karma)
    {
        AttributeInstance attack_damage = player.getAttribute(Attribute.ATTACK_DAMAGE);
        assert attack_damage != null;
        AttributeInstance health = player.getAttribute(Attribute.MAX_HEALTH);
        assert health != null;
        AttributeInstance mining_speed = player.getAttribute(Attribute.BLOCK_BREAK_SPEED);
        assert  mining_speed != null;

        if (karma > 2000)
        {
            attack_damage.setBaseValue(4);
            health.setBaseValue(28);
            mining_speed.setBaseValue(2);

        }
        else if (karma > 1500)
        {
            attack_damage.setBaseValue(3.5);
            health.setBaseValue(26);
            mining_speed.setBaseValue(1.8);

        }
        else if (karma > 1000)
        {
            attack_damage.setBaseValue(3);
            health.setBaseValue(24);
            mining_speed.setBaseValue(1.6);

        }
        else if (karma > 600)
        {
            attack_damage.setBaseValue(2);
            health.setBaseValue(22);
            mining_speed.setBaseValue(1.4);

        }
        else if (karma > 200)
        {
            attack_damage.setBaseValue(1.5);
            health.setBaseValue(22);
            mining_speed.setBaseValue(1.2);

        }
        else if (karma < -2000)
        {
            attack_damage.setBaseValue(-5);
            health.setBaseValue(12);
            mining_speed.setBaseValue(0.3);

        }
        else if (karma < -1500)
        {
            attack_damage.setBaseValue(-4);
            health.setBaseValue(14);
            mining_speed.setBaseValue(0.6);

        }
        else if (karma < -1000)
        {
            attack_damage.setBaseValue(-3);
            health.setBaseValue(16);
            mining_speed.setBaseValue(0.8);

        }
        else if (karma < -600)
        {
            attack_damage.setBaseValue(-2);
            health.setBaseValue(18);
            mining_speed.setBaseValue(0.9);

        }
        else if (karma < -200)
        {
            attack_damage.setBaseValue(1);
            health.setBaseValue(20);
            mining_speed.setBaseValue(1);

        }

    }

}
