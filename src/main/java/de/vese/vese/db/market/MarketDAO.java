package de.vese.vese.db.market;

import de.vese.vese.VESE;
import de.vese.vese.db.Column;
import de.vese.vese.db.DAO;
import de.vese.vese.db.DataBaseStructure;
import de.vese.vese.db.admin.AdminDataBaseConnection;
import de.vese.vese.db.admin.AdminDataBaseStructure;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketDAO extends DAO {

    /**
     * SimulationID is the ID of the Simulation this Market belongs to
     * TradingItem is the ID of the trading item (get it over the items table)
     * MarketID is the ID of the Market (used to access tables specific to the market)
     *          such as Offers
     */
    public static final DataBaseStructure MARKETDAO = new DataBaseStructure((Arrays.asList(
            new Column("SimulationID","VARCHAR(36)", true),
            new Column("TradingItemID","VARCHAR(32)",false),
            new Column("MarketID","VARCHAR(256)",false))));

    public MarketDAO(DataBaseStructure structure) {
        super(structure);
    }


    //Devins stuff
    @Override
    public DataBaseStructure getCurrentStructure() throws SQLException {

        //Connection connection = adminDataBaseConnection.getDataSource().getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM accounts");
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();
        DatabaseMetaData meta = connection.getMetaData();


        List<Column> columns = new ArrayList<>();

        int i = metaData.getColumnCount();


        String primaryKeyColumn = meta.getPrimaryKeys(null,null,"accounts").getMetaData().getColumnName(1);


        for(int j = 1; j < i+1; j++) {
            boolean primary = primaryKeyColumn.equals(metaData.getColumnLabel(j));
            columns.add(new Column(metaData.getColumnLabel(j), null, primary));
        }



        return new DataBaseStructure(columns);
    }

    @Override
    public void loadDataBase() throws SQLException {
        AdminDataBaseConnection con = VESE.getInstance().getAdminDataBaseConnection();
        con.executeUpdate("CREATE TABLE IF NOT EXISTS accounts(temp VARCHAR(1))");




        DataBaseStructure structure = getCurrentStructure();




        if(!DataBaseStructure.equals(structure, AdminDataBaseStructure.ACCOUNTDAO)) {
            updateDataBase(AdminDataBaseStructure.ACCOUNTDAO);
        }
    }

    @Override
    public void updateDataBase(DataBaseStructure structure) throws SQLException {

        DataBaseStructure oldStructure = getCurrentStructure();

        List<Column> columnsToBeAdded = new ArrayList<>();
        List<Column> columnsToBeDeleted = new ArrayList<>();



        for(Column column : structure.getColumnList()) {
            if(!DataBaseStructure.containsColumnIgnoreType(oldStructure.getColumnList(),column)) {
                columnsToBeAdded.add(column);
            }
        }

        for(Column column : oldStructure.getColumnList()) {
            if(!DataBaseStructure.containsColumnIgnoreType(structure.getColumnList(),column)) {
                columnsToBeDeleted.add(column);
            }
        }



        for(Column column : columnsToBeAdded) {
            AdminDataBaseConnection con = VESE.getInstance().getAdminDataBaseConnection();

            if(column.isPrimaryKey()) {
                con.executeUpdate("ALTER TABLE accounts ADD " +column.getName() +  " " + column.getSQLDataType() + " PRIMARY KEY");
            }else{
                con.executeUpdate("ALTER TABLE accounts ADD " +column.getName() +  " " + column.getSQLDataType());
            }

        }

        for(Column column : columnsToBeDeleted) {
            AdminDataBaseConnection con = VESE.getInstance().getAdminDataBaseConnection();
            con.executeUpdate("ALTER TABLE accounts DROP COLUMN " + column.getName());
        }


    }

}
