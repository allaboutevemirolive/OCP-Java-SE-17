package Experiment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String input_file = "input.txt";
        String output_file = "11.1. How to Write Tests.md";
        String formattedOutputFile = formatOutputFileName(output_file);

        try {
            String data = readInputFile(input_file);
            String newText = processData(data);

            writeOutputFile(formattedOutputFile, newText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatOutputFileName(String output_file) {
        String formattedFileName = output_file.replace(" ", "_").toLowerCase();
        return Paths.get(formattedFileName).toString();
    }

    public static String readInputFile(String input_file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input_file));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line);
        }
        reader.close();
        return data.toString();
    }

    public static String processData(String data) {
        data = data.replace(". ", ".\n");
        boolean insideBraces = false;
        StringBuilder newText = new StringBuilder();

        char[] dataChars = data.toCharArray();
        for (int i = 0; i < dataChars.length; i++) {
            char c = dataChars[i];
            if (c == '{') {
                insideBraces = true;
                newText.append(c);
            } else if (c == '}') {
                insideBraces = false;
                newText.append(c);
            } else if (!insideBraces) {
                switch (c) {
                    case '.':
                        newText.append(c);
                        if (i + 1 < dataChars.length) {
                            char nextChar = dataChars[i + 1];
                            if (!Character.isLowerCase(nextChar) && !Character.isDigit(nextChar)) {
                                newText.append('\n');
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

    public static void writeOutputFile(String output_file, String newText) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));
        writer.write(newText);
        writer.close();
    }
}
