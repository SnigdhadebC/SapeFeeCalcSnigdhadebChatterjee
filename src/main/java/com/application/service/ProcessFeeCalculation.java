package com.application.service;

import com.application.model.Transaction;
import com.application.util.Constants;

import java.util.List;

/**
 *
 */
public class ProcessFeeCalculation {

    /**
     *
     * @param transactionList
     * @return
     */
    public void processFees(List<Transaction> transactionList){
        for(Transaction transaction : transactionList){
            //•	$500 for a transaction with high priority
            if(transaction.getPriority()  == 'Y'){
                transaction.setProcessingFee(Constants.HIGH_PRIORITY_FEE);
            }else{
                //•	$100 for a transaction with normal priority and Transaction Type is Sell and Withdraw
                if(transaction.getTransactionType().equalsIgnoreCase("SELL") ||
                     transaction.getTransactionType().equalsIgnoreCase("WITHDRAW"))
                {
                    transaction.setProcessingFee(Constants.NORMAL_PRIORITY_FEE_SELL_WITHDRAW);
                }
                //•	$50 for a transaction with normal priority and Transaction Type Code is Buy and Deposit
                else if(transaction.getTransactionType().equalsIgnoreCase("BUY") ||
                        transaction.getTransactionType().equalsIgnoreCase("DEPOSIT"))
                {
                    transaction.setProcessingFee(Constants.NORMAL_PRIORITY_FEE_BUY_DEPOSIT);
                }
            }
        }
    }

    /**
     * Tntra-day transactions will have two transactions having same Client Id, Security Id, & Transaction Date
     * but opposite Transaction Type i.e. one transaction would be ‘Sell’ ‘& other would be ‘Buy’
     * @param dataList
     */
    public void checkForIntradayTransaction(List<Transaction> dataList) {
        for(Transaction transaction : dataList){
            for(int i = 0 ; i <dataList.size() ; i++){
                if(transaction.getClientId().equalsIgnoreCase(dataList.get(i).getClientId())
                    && transaction.getSecurityId().equalsIgnoreCase(dataList.get(i).getSecurityId())
                        && transaction.getTransactionDate().equals(dataList.get(i).getTransactionDate())){

                    if(transaction.getTransactionType().equalsIgnoreCase("BUY") && dataList.get(i).getTransactionType().equalsIgnoreCase("SELL") ||
                            (transaction.getTransactionType().equalsIgnoreCase("SELL") && dataList.get(i).getTransactionType().equalsIgnoreCase("BUY")) ){
                        transaction.setIntraDayTransaction(true);
                        //Each intra-day transaction should be charged $10
                        transaction.setProcessingFee(Constants.INTRADAY_TRANSACTION_FEE);
                    }
                }
            }
        }
    }
}
