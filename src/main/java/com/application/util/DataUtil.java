package com.application.util;

import com.application.model.Transaction;

import java.text.ParseException;

public class DataUtil {
    /**
     *
     * @param fileData
     * @return
     */
    public static Transaction populateTransactionData(String[] fileData) {
        Transaction transaction = null;
        if(fileData.length > 0){
            transaction = new Transaction();
            transaction.setExternalTransactionId(fileData[0]);
            transaction.setClientId(fileData[1]);
            transaction.setSecurityId(fileData[2]);
            transaction.setTransactionType(fileData[3]);
            try {
                transaction.setTransactionDate(DateFormatter.getDateFormatter().parse(fileData[4]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            transaction.setMarketValue(Double.parseDouble(fileData[5]));
            transaction.setPriority(fileData[6].charAt(0));
        }
        return transaction;
    }

}
