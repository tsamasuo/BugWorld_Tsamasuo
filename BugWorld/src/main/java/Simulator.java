/**
 * Created by tsamasuo on 28/04/2018.
 */
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Simulator{


    public static void main(String[] args) {
        JFrame f = new JFrame();

        World p = new World(); //Calling methods in class world to load .
        f.setSize(10,10);
        //f.setContentPane(p)
        f.setTitle("Welcome to Bug Wars");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
/* to do code*/
}

