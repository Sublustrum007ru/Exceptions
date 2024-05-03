package model.repository.impl;

import model.repository.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperation implements Operation {

    @Override
    public File createFileName(String args) throws IOException {
        String path = "src/DB/" + args + ".txt";
        File result = new File(path);
        result.getParentFile().mkdirs();
        result.createNewFile();
        return result;
    }


}
