package de.vese.vese.db.admin;
import de.vese.vese.db.Column;
import de.vese.vese.db.DataBaseStructure;
import java.util.Arrays;

public class AdminDataBaseStructure {


    public static final DataBaseStructure ACCOUNTDAO = new DataBaseStructure((Arrays.asList(
            new Column("UUID","VARCHAR(36)", true),
            new Column("userName","VARCHAR(32)",false),
            new Column("password","VARCHAR(256)",false),
            new Column("lastLogin","LONG",false),
            new Column("lastLogout","LONG", false),
            new Column("accountRegistration","LONG",false))));
}
