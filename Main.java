import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "11.7 Generic Methods and Constructors.md";
        String textToBeReplaced = "Click here to view code image";
        outputFile = formatOutputFileName(outputFile);

        try {
            String data = readInputFile(inputFile);
            String newText = processData(data, textToBeReplaced);
            writeOutputFile(outputFile, newText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatOutputFileName(String outputFile) {
        outputFile = outputFile.replace(" ", "_").toLowerCase();
        return outputFile;
    }

    public static String readInputFile(String inputFile) throws IOException {
        Path path = Paths.get(inputFile);
        return Files.readString(path);
    }

    private static boolean isSymbol(char c) {
        // List of symbols
        String symbols = "/\\:*?\"<>|!@#$%^&()-+=[]{};,.\'~`";
        return symbols.contains(String.valueOf(c));
    }

    public static String deleteEntireline(String data, String textToBeDeleted) {
        StringBuilder newData = new StringBuilder();
        String[] lines = data.split("\n");

        for (String line : lines) {
            if (!line.contains(textToBeDeleted)) {
                newData.append(line).append("\n");
            }
        }

        return newData.toString();
    }

    public static String processData(String data, String textToBeReplaced) {

        data = deleteEntireline(data, textToBeReplaced);

        // process a dot sign followed by a space that is not followed by a valid character, number, or lowercase letter
        data = data.replaceAll("\\. (?![a-z0-9])", ".\n");

        boolean insideBraces = false;
        Deque<Character> braceStack = new ArrayDeque<>();
        StringBuilder newText = new StringBuilder();

        char[] dataChars = data.toCharArray();
        for (int i = 0; i < dataChars.length; i++) {
            char c = dataChars[i];
            if (c == '{') {
                insideBraces = true;
                braceStack.push(c);
                newText.append(c);
            } else if (c == '}') {
                braceStack.pop();
                insideBraces = !braceStack.isEmpty();
                newText.append(c);
            } else if (!insideBraces) {
                if (c == '.') {
                    newText.append('.');
                    if (i + 1 < dataChars.length) {
                        char nextChar = dataChars[i + 1];
                        if (!Character.isLowerCase(nextChar) && !Character.isDigit(nextChar) && nextChar != '.' && !isSymbol(nextChar)) {
                            newText.append('\n');
                        }
                    }

                // } else if (c ==  '<') {
                //     newText.append('_');
                // } else if ( c == '>') {
                //     newText.append('_');
                } else {
                    newText.append(c);
                }
            } else {
                newText.append(c);
            }
        }

        return newText.toString();
    }

    public static void writeOutputFile(String outputFile, String newText) throws IOException {
        Path path = Paths.get(outputFile);
        Files.writeString(path, newText);
    }
}
