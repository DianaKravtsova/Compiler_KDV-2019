package bstu.it.kravstova;

import java.util.List;

public class Satellites {
    public String Name;
    public float Radius;
    public float Distance_to_Planet;
    public String PlanetName;

    @Override
    public String toString() {
        return '\n' + "Satellites{" +
                "Name='" + Name + '\'' +
                ", Radius=" + Radius +
                ", DistanceToPlanet=" + Distance_to_Planet +
                ", PlanetName= '" + PlanetName + '\'' + '}';
    }
}