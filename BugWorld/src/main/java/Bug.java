/**
 * Created by tsamasuo on 28/04/2018.
 */
import org.junit.Assert;
import org.junit.Test;

public class Bug extends Brain  implements CellItem {

    private int identity;
    private int state;
    private int brainStateIndex;
    private enum color{red, black}
    private int resting;
    private int direction;
    private boolean hasFood;


    private boolean mark(){
        boolean marker = true;
        return marker;
    }

    private boolean unmark(){
        boolean m = true;
        return m;
    }
    private void pickUp(){
        /*
        code to move bug
         */
    }
    private void drop(FoodParticle f){
        /*
        code to move bug
         */
    }
    private boolean flip(){
        return true;
    }
    private int direction(){
        return direction;
    }
    private boolean placeAt(Cell c){
        return true;
    }

    public int getIdentity(Cell c){
        return this.identity;
    }
    public int getState(Cell c){
        return this.state;
    }
    public int getBrainStateIndex(Cell c){
        return this.brainStateIndex;
    }
    public int getDirection(Cell c){
        return this.direction;
    }


}
