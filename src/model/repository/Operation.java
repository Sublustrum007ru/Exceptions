package model.repository;

import java.io.File;
import java.io.IOException;

public interface Operation {
    File createFileName(String args) throws IOException;
}
