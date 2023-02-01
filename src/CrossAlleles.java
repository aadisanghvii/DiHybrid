import org.jetbrains.annotations.NotNull;

public class CrossAlleles {
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
    private char @NotNull [] populateChars(String @NotNull [] parentAlleles) {
        // result should be of length 8
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
    public char[] calculateCross(String @NotNull [] firstParentAlleles, String @NotNull [] secondParentAlleles) {
        // length of 8
        char[] firstParentChars = populateChars(firstParentAlleles);
        char[] secondParentChars = populateChars(secondParentAlleles);

        // should be of length 16
        String[] result = new String[firstParentAlleles.length << 2];

        for (int i = 0; i < result.length; i++) {
            String currentAllele = "";
            
        }


        return firstParentChars;
    }
    public static void main(String[] args) {
        CrossAlleles cross = new CrossAlleles();

        String[] array = {"GT", "Gt", "gT", "gt"};
        String[] array2 = {"GT", "Gt", "gT", "gt"};

        char[] result = cross.calculateCross(array, array2);

        for (char num : result) {
            System.out.print(num + ", ");
        }
    }
}
