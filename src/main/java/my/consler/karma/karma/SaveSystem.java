package my.consler.karma.karma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class SaveSystem
{
    public static HashMap<UUID, Integer> read_savefile() throws IOException
    {
        HashMap<UUID, Integer> hashmap = new HashMap<>();
        try
        {
            File savefile = new File("karma_savefile.txt");

            Scanner s = new Scanner(savefile);
            while ( s.hasNextLine())
            {
                String data = s.nextLine();

                String[] sdata = data.split(" ");
                hashmap.put( UUID.fromString( sdata[0]), Integer.valueOf( sdata[1]));

            }

            s.close();

        }
        catch (FileNotFoundException e)
        {
            create_savefile();

        }

        return hashmap;

    }

    public static void create_savefile()
    {

        File savefile = new File("karma_savefile.txt");
        try
        {
            if (savefile.createNewFile())
            {
                System.out.println("Savefile created: " + savefile.getPath());

            }

        }
        catch (IOException e)
        {
            System.err.println("A strange error occurred while creating the save file for Karma Plugin. Please, report the bug \n" + e.getMessage());

        }

    }

    public static void write_to_savefile(HashMap<UUID, Integer> hashmap) throws IOException
    {
        FileWriter w = new FileWriter("karma_savefile.txt");
        for(UUID u : hashmap.keySet())
        {
            w.write(u.toString() + " " + hashmap.get(u) + "\n");

        }

        w.close();

    }

}