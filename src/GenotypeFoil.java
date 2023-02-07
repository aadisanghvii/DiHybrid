import org.jetbrains.annotations.NotNull;

public class GenotypeFoil {
    // foil = first, outside, inside, last

    public String[] foil(@NotNull String genotype) {
        // GgTt
        // 0123
        String[] result = new String[4];

        // 1st char, 3rd char
        result[0] = genotype.substring(0, 1) + genotype.charAt(2);

        // 1st char, 4rd char
        result[1] = genotype.substring(0, 1) + genotype.charAt(3);

        // 2st char, 3rd char
        result[2] = genotype.substring(1, 2) + genotype.charAt(2);

        // 2st char, 4rd char
        result[3] = genotype.substring(1, 2) + genotype.charAt(3);

        return result;
    }
}