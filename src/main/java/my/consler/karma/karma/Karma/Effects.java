package my.consler.karma.karma.Karma;

import org.apache.commons.lang3.Range;
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

        if (karma >= 2000)
        {
            attack_damage.setBaseValue(4);
            health.setBaseValue(28);
            mining_speed.setBaseValue(2);

        }
        else if ( Range.between( 1000, 1999).contains( karma))
        {
            attack_damage.setBaseValue(3.5);
            health.setBaseValue(26);
            mining_speed.setBaseValue(1.8);

        }
        else if (Range.between( 600, 999).contains( karma))
        {
            attack_damage.setBaseValue(3);
            health.setBaseValue(24);
            mining_speed.setBaseValue(1.6);

        }
        else if (Range.between( 201, 599).contains( karma))
        {
            attack_damage.setBaseValue(2);
            health.setBaseValue(22);
            mining_speed.setBaseValue(1.4);

        }
        else if (Range.between( 0, 200).contains( karma))
        {
            attack_damage.setBaseValue(1);
            health.setBaseValue(20);
            mining_speed.setBaseValue(1);

        }
        else if (Range.between( -199, -1).contains( karma))
        {
            attack_damage.setBaseValue(-1);
            health.setBaseValue(18);
            mining_speed.setBaseValue(0.9);

        }
        else if (Range.between( -599, -200).contains( karma))
        {
            attack_damage.setBaseValue(-2);
            health.setBaseValue(16);
            mining_speed.setBaseValue(0.8);

        }
        else if (Range.between( -999, -600).contains( karma))
        {
            attack_damage.setBaseValue(-3);
            health.setBaseValue(14);
            mining_speed.setBaseValue(0.7);

        }
        else if (Range.between( -1999, -1000).contains( karma))
        {
            attack_damage.setBaseValue(-5);
            health.setBaseValue(10);
            mining_speed.setBaseValue(0.5);

        }
        else if (karma <= -2000)
        {
            attack_damage.setBaseValue(-10);
            health.setBaseValue(4);
            mining_speed.setBaseValue(0.2);

        }



    }

}
