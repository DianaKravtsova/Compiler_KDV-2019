package bstu.it.kravstova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDAO implements IDAO {

    private static final String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Space;integratedSecurity=true\";";

    public MyDAO(){
        try{
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public IGenDAO<Planet, Integer> getPlanetsDAO(Connection connection) {
        return new MyDAO_Planet(connection);
    }

    @Override
    public IGenDAO<Satellites, Integer> getSatellitesDAO(Connection connection) {
        return new MyDAO_Sattelites(connection);
    }
}