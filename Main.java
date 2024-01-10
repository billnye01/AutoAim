

import Raycast.Raycast;
import Var.Pos;

public class Main {

    public static void main(String[] args) {

        Raycast raycast = new Raycast();

        // where robot is located reltive to the center of the allice wall
        Pos origin = new Pos(10, 10);
        // where the taget is located reltive to the center of the allice wall
        Pos end = new Pos(0, 0);

        // left most pillar is located reltive to the center of the allice wall
        Pos PillerLeft = new Pos(3, 5);
        //bottom most pillar is located reltive to the center of the allice wall
        Pos Pillerbottom = new Pos(5,3);
        //right most pillar is located reltive to the center of the allice wall
        Pos PillerRight = new Pos(7, 5);

        Pos[] map = new Pos[]{PillerLeft, PillerRight, Pillerbottom};

        // gets are angle needed for robot
        float yAngle = (float)Math.toDegrees(Math.atan((double)(end.y - origin.y) / (double)(end.x - origin.x)));

        //runs comand if robot hits the target
        if(raycast.IfHit(origin, end, map, 0.5f)){
            System.out.println("Hit " + yAngle);
        }else{
            System.out.println("Miss taget");
        }
    }

}

