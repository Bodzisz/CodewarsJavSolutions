package textAlignJustify;

import java.util.ArrayList;
import java.util.List;

// https://www.codewars.com/kata/537e18b6147aa838f600001b/
public class TextAlignJustify {
    public static String justify(String text, int width) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");
        int lineCount = 0;
        List<String> currentLineWords = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            int wordLength = words[i].length();
            if(lineCount == 0 && wordLength >= width) {
                currentLineWords.add(words[i]);
                if(i == words.length - 1) {
                    result.append(createLastLine(currentLineWords));
                }
                else {
                    result.append(createLine(currentLineWords, width));
                }
                currentLineWords.clear();
                lineCount = 0;
            }
            else {
                lineCount += wordLength;
                if(lineCount == width || lineCount + 1 == width) {
                    currentLineWords.add(words[i]);
                    if(i == words.length - 1) {
                        result.append(createLastLine(currentLineWords));
                    }
                    else {
                        result.append(createLine(currentLineWords, width));
                    }
                    currentLineWords.clear();
                    lineCount = 0;
                }
                else if(lineCount > width) {
                    result.append(createLine(currentLineWords, width));
                    currentLineWords.clear();
                    currentLineWords.add(words[i]);
                    lineCount = wordLength + 1;
                }
                else {
                    lineCount++;
                    currentLineWords.add(words[i]);
                }
            }
        }
        if(!currentLineWords.isEmpty()) {
            result.append(createLastLine(currentLineWords));
        }
        return result.toString();
    }

    private static String createLine(List<String> words, int width) {
        if(words.size() == 1) {
            return words.get(0) + "\n";
        }
        StringBuilder line = new StringBuilder();
        int[] spaceIndexes = createOneSpaceLineWithSpaceIndexes(words, line);

        processSpaces(line, spaceIndexes, width);
        line.append("\n");
        return line.toString();
    }

    private static int[] createOneSpaceLineWithSpaceIndexes(List<String> words, StringBuilder line) {
        int spaceIter = 0;
        int[] spaceIndexes = new int[words.size() - 1];
        for(String word : words) {
            line.append(word).append(" ");
            if(spaceIter < words.size() - 1) {
                spaceIndexes[spaceIter] = line.length() - 1;
                spaceIter++;
            }
        }
        line.deleteCharAt(line.length() - 1);
        return spaceIndexes;
    }

    private static void processSpaces(StringBuilder line, int[] spaceAppenders, int width) {
        int spaceIter = 0;
        while(line.length() != width) {
            line.insert(spaceAppenders[spaceIter], ' ');
            updateSpaceAppenders(spaceAppenders, spaceIter + 1);
            spaceIter++;
            if(spaceIter == spaceAppenders.length) {
                spaceIter = 0;
            }
        }
    }

    private static void updateSpaceAppenders(int[] spaceAppenders, int startFrom) {
        for(int i = startFrom; i < spaceAppenders.length; i++) {
            spaceAppenders[i] = spaceAppenders[i] + 1;
        }
    }

    private static String createLastLine(List<String> words) {
        StringBuilder line = new StringBuilder();
        for(String word : words) {
            line.append(word).append(" ");
        }
        line.deleteCharAt(line.length() - 1);
        return line.toString();
    }
}
