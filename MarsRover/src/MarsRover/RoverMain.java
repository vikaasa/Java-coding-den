package MarsRover;

import java.util.*;


/**
 * Created by Vikaasa on 3/4/2016.
 */
public class RoverMain {
    public static void main(String[] args) {
        RoverDirections test=new RoverDirections(0,0,'N');
        test.displayRover();
        test.moveForward();
        test.displayRover();
        /*int n='N';
        int s='S';
        int w='W';
        int e='E';
        System.out.println(n+" "+s+" "+w+" "+e);
        char nn=78;
        char ss=83;
        char ww=87;
        char ee=69;
        System.out.println(nn+" "+ss+" "+ww+" "+ee);*/
        test.turnLeft();
        test.moveForward();
        test.displayRover();
        test.turnRight();
        test.displayRover();
        test.moveForward();
        test.displayRover();
    }
}
