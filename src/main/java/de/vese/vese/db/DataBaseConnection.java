package de.vese.vese.db;

import java.sql.SQLException;

public interface DataBaseConnection {

    void loadDataBaseStructure() throws SQLException;
    void executeUpdate(String SQL, Object... objects) throws SQLException;

}
