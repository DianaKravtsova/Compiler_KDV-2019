package bstu.it.kravstova;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.util.StringTokenizer;

public class MyDAO_Planet implements IGenDAO<Planet, Integer> {
    private final Connection connection;

    public List<String> parser(String str)
    {
        List<String> res = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str,", ", false);
        while(tokenizer.hasMoreTokens()) {
            res.add(tokenizer.nextToken());
        }
        return res;
    }

    public MyDAO_Planet(Connection connection){
        this.connection = connection;
    }

    public List<Planet> planetsWithLife() throws SQLException{
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet WHERE IsLife = 'Y';";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planet> planets = new ArrayList<Planet>();
        while(rs.next()){
            Planet p = new Planet();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getInt("Temperature");
            p.Radius = rs.getInt("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            planets.add(p);
        }
        return planets;
    }

    @Override
    public Planet read(String key) throws SQLException {
        String sql = "SELECT * FROM Planet WHERE Name = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, key);
        ResultSet rs = stm.executeQuery();
        rs.next();
        Planet p = new Planet();
        p.Name = rs.getString("Name");
        p.IsLife = rs.getString("IsLife");
        p.IsAtmosphere = rs.getString("IsAtmosphere");
        p.Temperature = rs.getFloat("Temperature");
        p.Radius = rs.getFloat("Radius");
        p.Satellites = this.parser(rs.getString("Satellites"));
        return p;
    }

    @Override
    public List<Planet> getAll() throws SQLException {
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planet> planets = new ArrayList<Planet>();
        while(rs.next()){
            Planet p = new Planet();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getFloat("Temperature");
            p.Radius = rs.getFloat("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            planets.add(p);
        }
        return planets;
    }
}