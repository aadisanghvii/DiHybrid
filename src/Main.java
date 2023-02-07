import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    @Contract(pure = true)
    public @NotNull Map<String, Integer> occurrences(String @NotNull [] input) {
        Map<String, Integer> map = new HashMap<>();

        int currentOccurrences = 0;

        for (String value : input) {
            for (String s : input) {
                if (value.equals(s)) {
                    currentOccurrences++;
                }
            }

            map.put(value, currentOccurrences);
            currentOccurrences = 0;
        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        GenotypeFoil foilGenotypes = new GenotypeFoil();
        CrossAlleles cross = new CrossAlleles();

        System.out.println("What was the genotype for the first parent? (ex. GgTt) >>> ");
        String firstParentGenotypes = userInput.readLine();

        System.out.println("What was the genotype for the second parent? (ex. GgTt) >>> ");
        String secondParentGenotypes = userInput.readLine();

        String[] firstParentAlleles = foilGenotypes.foil(firstParentGenotypes);
        String[] secondParentAlleles = foilGenotypes.foil(secondParentGenotypes);


        String[] array = {"Gg"};
        String[] array2 = {"Gg"};

        String[] result = cross.calculateCross(array, array2);

        for (String num : result) {
            System.out.print(num + ", ");
        }
    }
}