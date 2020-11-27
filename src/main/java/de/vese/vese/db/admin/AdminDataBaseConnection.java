package de.vese.vese.db.admin;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.vese.vese.VESE;
import de.vese.vese.db.DataBaseConnection;
import de.vese.vese.exceptions.IllegalCreationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDataBaseConnection implements DataBaseConnection {

    private AdminDataBaseConnection INSTANCE = null;
    private HikariConfig config;
    private HikariDataSource dataSource;

    public AdminDataBaseConnection() throws IllegalCreationException {

        if(INSTANCE != null) throw new IllegalCreationException("There is already an instance of " + getClass().getName());

        INSTANCE = this;

        String user = VESE.getInstance().getConfig().getDAO().getString("SQL_USER");
        String password = VESE.getInstance().getConfig().getDAO().getString("SQL_PASSWORD");
        String port = VESE.getInstance().getConfig().getDAO().getString("SQL_PORT");
        String host = VESE.getInstance().getConfig().getDAO().getString("SQL_HOST");
        String database = VESE.getInstance().getConfig().getDAO().getString("ADMIN_SQL_DATABASE");
        config = new HikariConfig();
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setMaxLifetime(50000);
        config.setDriverClassName("org.mariadb.jdbc.Driver");

        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);

        dataSource = new HikariDataSource(config);

    }

    @Override
    public void loadDataBaseStructure() throws SQLException {

    }

    @Override
    public void executeUpdate(String SQL, Object... objects) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement ps = connection.prepareStatement(SQL);
        for(int i = 0; i < objects.length; i++) {
            ps.setObject(i+1, objects[i]);
        }

        ps.executeUpdate();
        ps.close();
        connection.close();

    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }
}
