/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivan.app.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author ivan
 */
public class ExportDataServiceDocImpl implements ExportDataSerciveStrategy {

    private static final Logger LOGGER = LogManager.getLogger(ExportDataServiceDocImpl.class);

    @Override
    public void exportData(Map<String, List<String>> data, String fileName) {
        File f = new File(fileName + ".docx");

        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out;
        try {
            out = new FileOutputStream(f);
            //create table
            XWPFTable table = document.createTable();

            boolean isFirst = true;
            for (String k : data.keySet()) {
                XWPFTableRow tableRowOne = table.getRow(0);
                if (isFirst) {
                    tableRowOne.getCell(0).setText(k);
                    isFirst = false;
                } else {
                    tableRowOne.addNewTableCell().setText(k);
                }
            }

            List<Iterator<String>> iterators = new ArrayList<>();

            data.keySet().forEach(k -> {
                iterators.add(data.get(k).iterator());
            });

            while (iterators.stream().anyMatch(itr -> itr.hasNext())) {
                XWPFTableRow tableRowTwo = table.createRow();
                int count = 0;

                for (Iterator<String> itr : iterators) {
                    String str = itr.next();
                    if (str != null) {
                        tableRowTwo.getCell(count).setText(str);
                    } else {
                        tableRowTwo.getCell(count).setText("");
                    }
                    count++;

                }
            }

            document.write(out);
            out.close();

        } catch (IOException ex) {
            LOGGER.error(ex);
        }

    }

}
