package my.consler.karma.karma;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Config
{
    public static File config_file = new File("karma.yml");

    public static Yaml yaml = new Yaml();
    public static InputStream inputStream;

    static
    {
        try
        {
            inputStream = new FileInputStream(config_file);
        }
        catch ( FileNotFoundException e)
        {
            try
            {
                Files.copy(Objects.requireNonNull( Main.class.getClassLoader().getResourceAsStream("karma.yml")), config_file.toPath());

            }
            catch (IOException exc)
            {
                System.err.println("A strange error occurred while filling in the config file for Karma Plugin. Please, report the bug \n" + Arrays.toString(e.getStackTrace()));

            }

            try
            {
                inputStream = new FileInputStream(config_file);
            }
            catch ( FileNotFoundException ex)
            {
                System.err.println("A strange error occurred while creating the config file for Karma Plugin. Please, report the bug \n" + ex.getCause());
            }

        }

    }
    public static Map<String, Object> obj = yaml.load(inputStream);

    @SuppressWarnings("unchecked")
    public static Map<String, Object> classes = (Map<String, Object>) obj.get("Classes");
    @SuppressWarnings("unchecked")
    public static List<String> monster = (List<String>) classes.get("Monster");
    @SuppressWarnings("unchecked")
    public static List<String> friend = (List<String>) classes.get("Friendly");
    @SuppressWarnings("unchecked")
    public static List<String> neuter = (List<String>) classes.get("Neuter");

    @SuppressWarnings("unchecked")
    public static Map<String, Object> damage_values = (Map<String, Object>) obj.get("DamageValues");
    @SuppressWarnings("unchecked")
    public static Map<String, Object> kill_values = (Map<String, Object>) obj.get("KillValues");

    public static int earn_karma_delay = (int) obj.get("Earn-karma-delay");
    public static int lose_karma_delay = (int) obj.get("Lose-karma-delay");

    public static int tnt_prime = (int) obj.get("TNT-Prime");
    public static int end_crystal_explode = (int) obj.get("End-crystal-explode");

    public static int advancement = (int) obj.get("Advancement");
    public static int challenge = (int) obj.get("Challenge");

    @SuppressWarnings("unchecked")
    public static Map<String, Object> custom = (Map<String, Object>) obj.get("Custom");

    @SuppressWarnings("unchecked")
    public static List<String> banned_words = (ArrayList<String>) obj.get("Banned-words");
    public static int type_banned_word = (int) obj.get("Type-banned-word");

    @SuppressWarnings("unchecked")
    public static Map<String, Object> player = (Map<String, Object>) obj.get("Player");
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> naked_player_values = (Map<String, Integer>) player.get("Naked");
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> spawn_killed_player_values = (Map<String, Integer>) player.get("HasJustRespawned");
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> normal_player_values = (Map<String, Integer>) player.get("Normal");

    public static int breeding = (int) obj.get("Breeding");

    public static int collect_flower = (int) obj.get("Collect-flower");

    @SuppressWarnings("unchecked")
    public static Map<Integer, Map<String, Map<String, Object>>> effects =  (Map<Integer, Map<String, Map<String, Object>>> ) obj.get("Effects");

}
