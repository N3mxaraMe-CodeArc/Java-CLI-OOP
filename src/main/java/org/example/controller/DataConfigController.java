package org.example.controller;

import org.example.model.DataConfigModel;
import org.example.service.DataConfigService;

import java.io.FileNotFoundException;

public class DataConfigController {

    private final DataConfigService dataConfigService = new DataConfigService();

//    public DataConfigModel addDataConfig(int totalTickets , int ticketReleaseRate , int customerRetrievalRate , int maxTicketCapacity){
//        DataConfigModel dataConfigModel = new DataConfigModel(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
//        return dataConfigService.addDataConfig(dataConfigModel);
//    }

    public boolean saveToTheFile(DataConfigModel dataConfigModel) throws FileNotFoundException {
        return dataConfigService.saveToTheFile(dataConfigModel);
    }

    public DataConfigModel LoadDataConfig() throws FileNotFoundException {
        return dataConfigService.readFromFile();
    }
}
