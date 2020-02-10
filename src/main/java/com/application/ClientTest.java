package com.application;

import com.application.model.Transaction;
import com.application.service.CSVFileUtilityImpl;
import com.application.service.FileUtility;
import com.application.service.ProcessFeeCalculation;
import com.application.util.DataUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;

public class ClientTest {

    ProcessFeeCalculation processFee = new ProcessFeeCalculation();

    public static void main(String[] args) {

        ClientTest client = new ClientTest();
        // 1. Get the file path location
        String filename = "sample_data.csv";
        String fileExtension = filename.substring(filename.lastIndexOf(".")+1,filename.length()).toLowerCase();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(filename);

        switch(fileExtension){
            case "csv" : {
                FileUtility fileUtility = new CSVFileUtilityImpl();
                try {
                    client.doOperations(fileUtility,resourceAsStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "xls" : {
                // For XLS file we will create object of that class
                break;
            }
            default:
                System.out.println("Please provide a valid file");
        }

    }

    /**
     *
     * @param fileUtility
     * @param resourceAsStream
     * @throws IOException
     */
    public void doOperations(FileUtility fileUtility,InputStream resourceAsStream) throws IOException {
        //1. Read from file
        List<Transaction> dataList = fileUtility.readFromFile(resourceAsStream);
        //2. Business Logic - Implementing Processing Rules
        processFee.processFees(dataList);
        //3. Check for Intraday transaction
        processFee.checkForIntradayTransaction(dataList);

        //4. Report should be sorted by the Client Id, Transaction Type, Transaction Date and Priority.
         dataList.sort(
                Comparator.comparing(Transaction::getClientId)
                .thenComparing(Transaction::getTransactionType)
                .thenComparing(Transaction::getTransactionDate)
                .thenComparing(Transaction::getPriority));

        //5. Populate the final data on console
        fileUtility.printDataToConsole(dataList);
    }
}
