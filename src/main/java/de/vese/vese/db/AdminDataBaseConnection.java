package de.vese.vese.db;

import com.zaxxer.hikari.HikariConfig;
import de.vese.vese.VESE;
import de.vese.vese.exceptions.IllegalCreationException;
import de.vese.vese.filemanager.ConfigFileManager;

public class DataBaseConnection {

    private DataBaseConnection INSTANCE = null;
    private HikariConfig config;

    public DataBaseConnection() throws IllegalCreationException {

        if(INSTANCE != null) throw new IllegalCreationException("There is already an instance of " + getClass().getName());

        INSTANCE = this;

        String user = VESE.getInstance().getConfig().getDAO().getString("SQL_USER");
        String password = VESE.getInstance().getConfig().getDAO().getString("SQL_PASSWORD");
        String port = VESE.getInstance().getConfig().getDAO().getString("SQL_PORT");
        String host = VESE.getInstance().getConfig().getDAO().getString("SQL_HOST");

        config = new HikariConfig();
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setMaxLifetime(50000);

        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + "");


    }




}
