package de.vese.vese.db;

import java.util.Collection;
import java.util.List;


/**
 * Models a Databasestrucute, used to compare already existing database systems to new given ones.
 *
 * @author Devin
 * @version 1.0.0
 */

public class DataBaseStructure {

    private List<Column> columnList;

    public DataBaseStructure(List<Column> coloumnList) {
        this.columnList = coloumnList;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    /**
     * compares 2 Database strcutures
     *
     * @param dataBaseStructure1 for first
     * @param dataBaseStructure2 for second
     * @return compare between 2 structures
     * */
    public static boolean equals(DataBaseStructure dataBaseStructure1, DataBaseStructure dataBaseStructure2) {

        if(dataBaseStructure1.getColumnList().size() != dataBaseStructure2.getColumnList().size()) return false;


        for(Column column1 : dataBaseStructure1.getColumnList()) {
            for(Column column2 : dataBaseStructure2.getColumnList()) {
                if(!column1.getName().equals(column2.getName())) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * Compares two given columns, by name and datatype.
     *
     * @param column1 compared to ->
     * @param column2
     * @return boolean
     */
    public static boolean compareColumns(Column column1, Column column2) {
        if(column1.getName().equals(column2.getName())) {
            if(column1.getSQLDataType().equals(column2.getSQLDataType())) return true;
        }
        return false;
    }


    /**
     *
     * @param columns collection of columns
     * @param column column checked if in columns
     * @return if column is includes in columns ignoring the dataType
     */
    public static boolean containsColumnIgnoreType(Collection<Column> columns, Column column) {

        for(Column inColumns : columns) {
            if(inColumns.getName().equals(column.getName())) return true;
        }

        return false;
    }

}
