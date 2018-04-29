/**
 * Created by tsamasuo on 28/04/2018.
 */
import javax.swing.JFrame;
import java.io.IOException;
import java.io.File;


public class Simulator implements Runnable{

    int rounds = 100000;

    public static boolean loadWorldMap(World w){
        //logic to load the world map
        return w.state;
    }

    public static void initWorld(World w, int rounds){
        //logic to initialise the world map
    }
    public static void loadBugBrain(Brain b){
        //logic to initialise the world map
    }
    public static int incrementCount(){
        //logic to count scores

        return 0;
    }
    public static boolean executeNextBugInstruction(Bug b){
        //logic to count scores

        return true;
    }

    public World simulate(String worldFilename)
            throws IOException
    {
        File worldFile = new File(worldFilename);


        World world = InputOutput.readMap(worldFilename);

        this.initWorld(world, rounds);
        this.run();


        return world;
    }

    public void run()
    {
        //

        return;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        World p = new World(); //Calling methods in class world to load .
        f.setSize(10,10);
        f.setContentPane(p);
        f.setTitle("Welcome to Bug Wars");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
/* to do code*/
}

