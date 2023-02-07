import org.jetbrains.annotations.NotNull;

public class CrossAlleles {
    private @NotNull String lowercaseReorder(@NotNull String input) {
        String result;

        if (Character.isLowerCase(input.charAt(0)) && Character.isUpperCase(input.charAt(1))) {
            result = charsConcat(input.charAt(1), input.charAt(0));
        }
        else if (Character.isUpperCase(input.charAt(0)) && Character.isLowerCase(input.charAt(1))) {
            result = charsConcat(input.charAt(0), input.charAt(1));
        }
        else {
            return input;
        }

        return result;
    }
    private @NotNull String charsConcat(char @NotNull ... chars) {
        StringBuilder result = new StringBuilder(chars.length);

        if (chars.length == 0) {
            return "";
        }
        for (char c : chars) {
            result.append(c);
        }
        return result.toString();
    }
    /**
     {@code populateChars} loop will match the following statements:

     <pre>
     {@code
     result[1] = parentAlleles[0].charAt(0);
     result[2] = parentAlleles[0].charAt(1);
     result[3] = parentAlleles[1].charAt(0);
     result[4] = parentAlleles[1].charAt(1);
     etc...
     }


     result[index] increments by 1
     parentAlleles[index] increments every other iteration
     charAt(index) shifts between 0 and 1
     </pre>

     */
    private char @NotNull [] populateChars(String @NotNull [] parentAlleles) {

        char[] result = new char[parentAlleles.length << 1];

        boolean firstOccurrence = true;
        int doubleIndex = 0;

        for (int i = 0; i < result.length; i++) {
            if (firstOccurrence) {
                result[i] = parentAlleles[doubleIndex].charAt(0);
                firstOccurrence = false;
            }
            else {
                result[i] = parentAlleles[doubleIndex].charAt(1);
                firstOccurrence = true;
                doubleIndex++;
            }
        }

        return result;
    }
    public String[] calculateCross(String @NotNull [] firstParentAlleles, String @NotNull [] secondParentAlleles) {
        String[] result = new String[4];

        char[] firstParentChars = populateChars(firstParentAlleles);
        char[] secondParentChars = populateChars(secondParentAlleles);

        int doubleIndex = 0;
        boolean firstOccurrence = true;

        for (int i = 0; i < result.length; i++) {
            if (firstOccurrence) {
                result[i] = lowercaseReorder(charsConcat(firstParentChars[doubleIndex], secondParentChars[0]));
                firstOccurrence = false;
            }
            else {
                result[i] = lowercaseReorder(charsConcat(firstParentChars[doubleIndex], secondParentChars[1]));
                firstOccurrence = true;
                doubleIndex++;
            }
        }

        return result;
    }
}