package service;

import model.Text;

import java.io.FileNotFoundException;

public interface TextConverter {

    void convert(Text text) throws FileNotFoundException;
}
