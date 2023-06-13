import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "11.1. How to Write Tests.md";
        outputFile = formatOutputFileName(outputFile);

        try {
            String data = readInputFile(inputFile);
            String newText = processData(data);
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
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line).append("\n");
        }
        reader.close();
        return data.toString();
    }

    public static String processData(String data) {
        data = data.replace(". ", ".\n");
        boolean insideBraces = false;
        Stack<Character> braceStack = new Stack<>();
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
                switch (c) {
                    case '.':
                        newText.append('.');
                        if (i + 1 < dataChars.length) {
                            char nextChar = dataChars[i + 1];
                            if (!Character.isLowerCase(nextChar) && !Character.isDigit(nextChar)) {
                                if (nextChar != ' ') {
                                    newText.append('\n');
                                }
                            }
                        }
                        break;
                    default:
                        newText.append(c);
                        break;
                }
            } else {
                newText.append(c);
            }
        }

        return newText.toString();
    }

    public static void writeOutputFile(String outputFile, String newText) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(newText);
        writer.close();
    }
}
