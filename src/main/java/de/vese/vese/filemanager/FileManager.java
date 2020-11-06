package de.vese.vese.filemanager;

import de.vese.vese.exceptions.CantReadFileException;
import org.json.JSONObject;

public interface FileManager {

    public void loadFile() throws CantReadFileException;
    public void saveFie();
    public JSONObject getDAO();



}
