package MarsRover;

import java.util.*;

/**
 * Created by Vikaasa on 3/3/2016.
 */
public class RoverDirections {
    int xaxis,yaxis;
    char direction;
    int currDir;
    public static final Map<Character,Integer> map1 = new HashMap<Character,Integer>() {
        {   put('N',0);
            put('W',90);
            put('S',180);
            put('E',270);
        }
    };

    public static final Map<Integer,Integer[]> map2 = new HashMap<Integer, Integer[]>() {
        {   Integer[] N = {0,1,78};
            Integer[] W = {-1,0,83};
            Integer[] S = {0,-1,87};
            Integer[] E = {1,0,69};
            put(0,N);
            put(90,W);
            put(180,S);
            put(270,E);
        }
    };

    public RoverDirections(int xaxis, int yaxis, char direction) {
        this.xaxis = xaxis;
        this.yaxis = yaxis;
        this.direction = direction;
        this.currDir=map1.get(direction);
    }

    public RoverDirections() {
        this.yaxis = 0;
        this.xaxis = 0;
        this.direction = 'N';
    }
    public char getDirection(){
        return direction;
    }

    public void turnLeft(){
        this.currDir=currDir+90;
        this.currDir=currDir%360;
        Integer[] tmp=map2.get(this.currDir);
        this.direction=(char)(int)tmp[2];
    }
    public void turnRight(){
        this.currDir=currDir+360;
        this.currDir=currDir-90;
        this.currDir=currDir%360;
        Integer[] tmp=map2.get(this.currDir);
        this.direction=(char)(int)tmp[2];
    }
    public void moveForward(){
        Integer[] moveCoordinates;
        moveCoordinates=map2.get(this.currDir);
        this.xaxis=this.xaxis+moveCoordinates[0];
        this.yaxis=this.yaxis+moveCoordinates[1];
    }
    public void commandQueue(String commands){
        int len=commands.length();
        for(int i=0;i<len;i++){
            if(commands.charAt(i)=='M'){
                 moveForward();;
            }
            else if(commands.charAt(i)=='L'){
                turnLeft();
            }
            else if(commands.charAt(i)=='R') {
                turnRight();
            }
            else {
                System.out.println("Invalid command!");
            }
        }
    }
    public void displayRover(){
        System.out.println(this.xaxis+" "+this.yaxis+" "+this.direction);
    }
}
