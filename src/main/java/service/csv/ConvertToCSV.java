package service.csv;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import model.Sentence;
import model.Text;
import service.TextConverter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertToCSV implements TextConverter {

    @Override
    public void convert(Text text) {
        int sentenceSize = text.getSentenceList().stream().mapToInt(s -> s.getWord().size()).max().orElse(0);
        String[] header = new String[sentenceSize + 1];;
        for (int i = 1; i <= sentenceSize; i++) {
            header[i] = "Word " + i;
        }
        List<String[]> data = new ArrayList<>();
        data.add(header);
        int counter = 1;
        for (Sentence sentence : text.getSentenceList()) {
            List<String> strings = new ArrayList<>();
            strings.add("Sentence " + counter);
            strings.addAll(sentence.getWord());
            data.add(strings.toArray(new String[0]));
            counter++;
        }
        writeToCsv(data);
    }


    private void writeToCsv(List<String[]> data) {
        File file = new File("result.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            ICSVWriter csvWriter = new CSVWriterBuilder(fileWriter)
                    .withSeparator(',')
                    .build();
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
