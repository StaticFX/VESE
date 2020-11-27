package de.vese.vese.db;

import java.sql.SQLException;


/**
 * abstract classed used as a default scheme used for an  DAO (dataAccessObject)
 *
 *
 */

public abstract class DAO {

    /**
     * indicates current structure of the database
     */
    private DataBaseStructure structure;

    public DAO(DataBaseStructure structure) {
        this.structure = structure;
    }


    /**
     *
     * Gets all the coloums from the table and puts them in a DatabaseStructure obj
     *
     * @return DataBaseStructure from the current table
     * @throws SQLException
     */
    public abstract DataBaseStructure getCurrentStructure() throws SQLException;


    /**
     * Loading the database and automatically updating if outdated
     * @throws SQLException
     */
    public abstract void loadDataBase() throws SQLException;

    /**
     * Syncs the old database structure to the given one.
     * Only accepts new columns or deleted ones. Renaming columns wont work.
     *
     * @param structure the database should be updated with
     * @throws SQLException
     */
    public abstract void updateDataBase(DataBaseStructure structure) throws SQLException;

}
