package service;

import model.FileType;
import model.Sentence;
import model.Text;
import service.xml.ConvertToXML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {

    private static final String SENTENCE_SPLITTER_REGEX = "(?<=[.!;?])(?<!Mr\\.|Mrs\\.|Dr\\.|Ms\\.)";
    private static final String CHARACTERS_TO_REMOVE_FROM_WORDS = "[\"().,!?:-]";

    ConvertToXML convertToXML = new ConvertToXML();

    public void parseString(String text, FileType fileType) {
        Text sortedText = splitAndSort(readText(text));

        if (fileType == FileType.XML) {
            convertToXML.convert(sortedText);
        }
    }

    private Text splitAndSort(String word) {
        String word2 = word.trim();
        List<String> allSentences = Arrays.stream(word2
                        .replaceAll(SENTENCE_SPLITTER_REGEX, "")
                        .split(CHARACTERS_TO_REMOVE_FROM_WORDS))
                .filter(w -> w.trim().length() > 0)
                .collect(Collectors.toList());
        List<Sentence> sentences = new ArrayList<>();
        for (String sentence : allSentences) {
            List<String> words = Arrays.asList(sentence.trim().split("\\W+"));
            words.sort(String.CASE_INSENSITIVE_ORDER);
            Sentence sentence2 = new Sentence();
            for (String w : words) {
                if (!w.isBlank()) {
                    sentence2.add(w);
                }
            }
            sentences.add(sentence2);
        }
        return new Text(sentences);
    }

    private String readText(String filePath) {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
