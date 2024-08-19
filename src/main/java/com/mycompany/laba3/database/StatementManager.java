package com.mycompany.laba3.database;

import com.mycompany.laba3.Reactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import javax.swing.table.DefaultTableModel;

 
public class StatementManager {
    private DatabaseConfigurer configurer;
    
    
    public StatementManager(DatabaseConfigurer configurer) {
        this.configurer = configurer;
    }
    
    public DefaultTableModel doStatement(String aggregationType) throws SQLException, ClassNotFoundException {
        Connection connection = configurer.getConnection();
        String sql = null;
        String[] titles = {aggregationType, "Год", "Объем_ежегодного_потребления"  };
        switch(aggregationType) {
            case "Страна":
                sql = "SELECT country as Страна, year as Год, " +
                 "SUM((ROUND(((thermalCapacity/burnup) * LoadFactor.loadFactor)/100, 2))) as Объем_ежегодного_потребления " +
                 "FROM ReactorsPris " +
                 "JOIN LoadFactor ON ReactorsPris.name = LoadFactor.reactor " +
                 "JOIN ReactorsTypes ON ReactorsPris.type = ReactorsTypes.type " +
                 "WHERE year <= 2023 " +
                 "GROUP BY country, year " +
                 "ORDER BY country, year;";
                break;
            case "Компания":
               sql = "SELECT operator as Компания, year as Год, " +
                 "SUM((ROUND(((thermalCapacity/burnup) * LoadFactor.loadFactor)/100,2))) as Объем_ежегодного_потребления " +
                 "FROM ReactorsPris " +
                 "JOIN LoadFactor ON ReactorsPris.name=LoadFactor.reactor " +
                 "JOIN ReactorsTypes ON ReactorsPris.type=ReactorsTypes.type " +
                 "WHERE year<=2023 " +
                 "GROUP BY operator, year " +
                 "ORDER BY operator, year;";
               break;
           case "Регион":
               sql = "SELECT region as " + titles[0] +", year as Год, " +
                 "SUM((ROUND(((thermalCapacity/burnup) * LoadFactor.loadFactor)/100,2))) as Объем_ежегодного_потребления " +
                 "FROM ReactorsPris " +
                 "JOIN Countries ON ReactorsPris.country = Countries.country " +
                 "JOIN LoadFactor ON ReactorsPris.name = LoadFactor.reactor " +
                 "JOIN ReactorsTypes ON ReactorsPris.type = ReactorsTypes.type " +
                 "WHERE year <= 2023 " +
                 "GROUP BY region, year " +
                 "ORDER BY region, year;";
               break;
           case "Реактор":
               sql = "SELECT name as Реактор, year as Год, " +
                 "SUM((ROUND(((thermalCapacity/burnup) * LoadFactor.loadFactor)/100,2))) as Объем_ежегодного_потребления " +
                 "FROM ReactorsPris " +
                 "JOIN LoadFactor ON ReactorsPris.name = LoadFactor.reactor " +
                 "JOIN ReactorsTypes ON ReactorsPris.type = ReactorsTypes.type " +
                 "WHERE year <= 2023 " +
                 "GROUP BY name, year " +
                 "ORDER BY name, year;";
               break;
        }  
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        DefaultTableModel model = getConsumptionModel(titles, resultSet);
        
        return model;
        
    }
    
    public void createAndFillReactorTypesTable(List<Reactor> reactorList)throws SQLException, ClassNotFoundException{
        Connection connection = configurer.createConnection();
        
        String sql = "DROP TABLE IF EXISTS ReactorsTypes;";
        
        Statement statement = connection.createStatement();
        statement.execute(sql);
        
        sql = "CREATE TABLE ReactorsTypes (" +
            "type VARCHAR(30)," +
            "burnup DECIMAL(10, 2)" +
            ");";
        
        PreparedStatement stat = connection.prepareStatement(sql);
        stat.execute();
        
        
        
        PreparedStatement prep = connection.prepareStatement("INSERT INTO ReactorsTypes VALUES (?, ?);");
        for (Reactor reactor : reactorList) {
            prep.setString(1, reactor.getClasse());
            prep.setDouble(2, Double.parseDouble(reactor.getBurnup()));
            prep.addBatch();
        }
        prep.executeBatch();
        
    }
    
    
    
    public DefaultTableModel getConsumptionModel(String[] titles, ResultSet resultSet) throws SQLException {
       
        DefaultTableModel model = new DefaultTableModel(titles, 0);
        String[] data = new String[3];
        while(resultSet.next()) {
            data[0] = String.valueOf(resultSet.getString(titles[0]));
            data[1] = String.valueOf(resultSet.getInt("Год"));
            data[2] =String.valueOf(resultSet.getFloat("Объем_ежегодного_потребления"));
            model.addRow(data);
        }
        return model;
        
                
    }
    
}
