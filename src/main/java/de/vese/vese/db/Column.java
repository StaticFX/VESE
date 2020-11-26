package de.vese.vese.db;

import org.jetbrains.annotations.Nullable;

public class Column {

    private String name;
    private String SQLDataType;
    private boolean primaryKey;

    public Column(@Nullable String name, @Nullable String SQLDataType, boolean primaryKey) {
        this.name = name;
        this.SQLDataType = SQLDataType;
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public String getSQLDataType() {
        return SQLDataType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }
}
