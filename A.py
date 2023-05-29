import os

inputFile  = 'input.txt'
outputFile = '11.2 Generic Types and Parameterized Types.md'
outputFile = outputFile.replace(" ", "_").lower()  # replaces space with underscore and lowercases filename

new_text = ""

with open(inputFile, 'r', encoding="utf-8") as f:
    data = f.read()
    data = data.replace(". ", ".\n")  # add newline after dot sign

    inside_braces = False
    for i in range(len(data)):
        if data[i] == "{":
            inside_braces = True
        elif data[i] == "}":
            inside_braces = False
        if (
            not inside_braces
            and data[i] == "."
            and i + 1 < len(data)
            and not (
                data[i + 1:i + 3] == "java"  # Exclude ".rs"
                or data[i - 1].isdigit()
                or data[i + 1].isdigit()
            )
        ):
            new_text += ".\n"
        else:
            new_text += data[i]

with open(outputFile, 'w', encoding="utf-8") as f:
    f.write(new_text)
