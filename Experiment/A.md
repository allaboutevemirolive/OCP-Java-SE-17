package Experiment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "11.2 Generic Types and Parameterized Types.md";
        String formattedOutputFileName = formatOutputFileName(outputFileName);

        String inputData = readInputFile(inputFileName);
        String processedData = processData(inputData);

        writeOutputFile(formattedOutputFileName, processedData);
    }

    private static String formatOutputFileName(String outputFileName) {
        return outputFileName.replace(" ", "_").toLowerCase();
    }

    private static String readInputFile(String inputFileName) {
        String inputData = "";
        try {
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                inputData += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    private static String processData(String data) {
        String processedData = data.replace(". ", ".\n");
        boolean insideBraces = false;
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < processedData.length(); i++) {
            char c = processedData.charAt(i);
            if (c == '{') {
                insideBraces = true;
                newString.append(c);
            } else if (c == '}') {
                insideBraces = false;
                newString.append(c);
            } else if (!insideBraces) {
                switch (c) {
                    case '.':
                        newString.append('.');
                        if (i + 1 < processedData.length()) {
                            char nextChar = processedData.charAt(i + 1);
                            if (!Character.isLowerCase(nextChar) && !Character.isDigit(nextChar)) {
                                newString.append('\n');
                            }
                        }
                        break;
                    default:
                        newString.append(c);
                        break;
                }
            } else {
                newString.append(c);
            }
        }

        return newString.toString();
    }

    private static void writeOutputFile(String outputFileName, String processedData) {
        try {
            File outputFile = new File(outputFileName);
            PrintWriter writer = new PrintWriter(outputFile);
            writer.write(processedData);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}