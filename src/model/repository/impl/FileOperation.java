package model.repository.impl;

import model.repository.Operation;

import java.util.List;

public class FileOperation implements Operation {
    @Override
    public List<String> readAll() {
        return List.of();
    }

    @Override
    public void saveAll(List<String> data) {

    }
}
