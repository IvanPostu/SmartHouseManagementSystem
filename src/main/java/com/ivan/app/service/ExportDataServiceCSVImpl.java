/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ivan
 */
public class ExportDataServiceCSVImpl implements ExportDataSerciveStrategy {

    private static final Logger LOGGER = LogManager.getLogger(ExportDataServiceCSVImpl.class);

    
    @Override
    public void exportData(Map<String, List<String>> data, String fileName) {

        File f = new File(fileName + ".csv");

        
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            List<Iterator<String>> iterators = new ArrayList<>();

            data.keySet().forEach(k -> {
                try {
                    writer.write(String.format("%-30s", k) + '\t');
                    iterators.add(data.get(k).iterator());
                } catch (IOException ex) {
                    LOGGER.error(ex);
                }
            });
            writer.write("\n");

            while (iterators.get(0).hasNext()) {
                StringBuilder sb = new StringBuilder();
                
                for (Iterator<String> itr : iterators) {
                    if (itr.hasNext()) {
                        sb.append(String.format("%-30s", itr.next())).append('\t');
                    }
                }
                String s = sb.toString();
                writer.write(s + "\n");
            }

        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

}
