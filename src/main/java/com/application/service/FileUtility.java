package com.application.service;

import com.application.model.Transaction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FileUtility {

    //1. To read content from file
    public List<Transaction> readFromFile(InputStream filePath) throws IOException;

    //2. To print data on the console
    public void printDataToConsole(List<Transaction> transactionList);


}
