package com.application.service;

import com.application.model.Transaction;
import com.application.util.DataUtil;
import com.application.util.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads data from CSV file
 */
public class CSVFileUtilityImpl implements FileUtility {

    private final String DELIMITER = ",";

    /**
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public List<Transaction> readFromFile(InputStream inputStream) throws IOException {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        String line = null;
        int count = 0;
        // Using try with resources Java 8
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
                while((line = reader.readLine()) != null){
                    if(count > 0){
                        String[]fileData = line.split(DELIMITER);
                        Transaction transaction = DataUtil.populateTransactionData(fileData);
                        transactionList.add(transaction);
                    }
                    count ++;
                }
            }
        return transactionList;
    }

    /**
     *
     * @param transactionList
     */
    public void printDataToConsole(List<Transaction> transactionList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee");
        sb.append("\n");
        for(Transaction transaction : transactionList){
            sb.append(transaction.getClientId() + "\t\t");
            sb.append(transaction.getTransactionType() + "\t\t");
            sb.append(DateFormatter.getDateFormatter().format(transaction.getTransactionDate()) + "\t\t");
            sb.append(transaction.getPriority() + "\t\t");
            sb.append(transaction.getProcessingFee() + "\t\t");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
