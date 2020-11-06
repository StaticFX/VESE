package de.vese.vese.filemanager;

import de.vese.vese.exceptions.CantReadFileException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigFileManager implements FileManager {

    private ConfigFileManager instance;
    private File file;
    private JSONObject DAO;

    public ConfigFileManager(File location) {
        this.file = location;

    }

    @Override
    public void loadFile() throws CantReadFileException {
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            try(InputStream in = getClass().getClassLoader().getResourceAsStream("config.json")) {
                Files.copy(in,file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            DAO = new JSONObject(content);
        } catch (Exception exception) {
            throw new CantReadFileException("Cant read json input file: config.json");
        }
    }

    @Override
    public void saveFie() {

    }

    @Override
    public JSONObject getDAO() {
        return null;
    }
}
