package bstu.it.kravstova;

import java.util.List;

public class Planet {
    public String Name;
    public float Radius;
    public float Temperature;
    public String IsAtmosphere;
    public String IsLife;
    public List<String> Satellites;
    @Override
    public String toString(){
        return '\n' + "Planet{"+
                "Name='"+Name+'\''+
                ", Radius="+Radius+
                ", Temperature="+Temperature+
                ", IsAtmosphere='"+IsAtmosphere+'\''+
                ", IsLife='"+IsLife+'\''+
                ", Satellites: " + Satellites.toString() + '}';
    }
}
