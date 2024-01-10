
package Raycast;

import Var.Pos;

public class Raycast {
    
    public boolean IfHit(Pos Origin, Pos End, Pos[] Map, float Limit) {

        Pos pos = Origin;
        // gets the slope of the line
        float Slope = (float)(End.y - Origin.y) / (float)(End.x - Origin.x);

        // are distance between the note and the pillars
        float[] Distanes = GetDistanes(pos, Map);

        while (pos.x > End.x && pos.y > End.y) {

            int ClosedPoint = 0;

            // gets the closest pillar
            for(int i = 0; i < Distanes.length; i++) {
                if(Distanes[i] < Distanes[ClosedPoint]) {
                    ClosedPoint = i;
                }
                // sees if the robot is within the limit
                if(Distanes[i] <= Limit) {
                    return false;
                }
            }

            // modfi position of robot
            pos.x -= 1 ;
            pos.y -= Math.round(Slope);
            
            // gets the distance between the note and the pillars
            Distanes = GetDistanes(pos, Map);
        }

        // note has a cleer shot on the target
        return true;
    }

    public float[] GetDistanes(Pos Pos, Pos[] Map) {

        float[] Distanes = new float[Map.length];

        for(int i = 0; i < Map.length; i++) {
            Distanes[i] = (float)Math.sqrt(Math.pow(Map[i].x - Pos.x, 2) + Math.pow(Map[i].y - Pos.y, 2));
        }

        return Distanes;
    }

}
