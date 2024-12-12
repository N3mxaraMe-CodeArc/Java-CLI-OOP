package org.example.service;
import com.google.gson.Gson;
import org.example.model.DataConfigModel;

import java.io.*;
import java.util.logging.Logger;

public class DataConfigService {

    Logger logger = Logger.getLogger(DataConfigService.class.getName());

    private final String TxtSourcePath = "D:\\IIT\\OOP\\Spring\\Devstack Practise\\OOP Ticketing System\\Java-CLI\\src\\main\\java\\org\\example\\Configurations.txt";

    public boolean saveToTheFile(DataConfigModel dataConfigModel){
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(dataConfigModel);
            FileWriter fileWriter = new FileWriter(TxtSourcePath);
            fileWriter.write(jsonString);
            logger.info("( Data Config ) - Data Configurations Saved Successfully");
            fileWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DataConfigModel readFromFile(){
        try {
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TxtSourcePath));
            return gson.fromJson(bufferedReader, DataConfigModel.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
