import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        GenotypeFoil foilGenotypes = new GenotypeFoil();

        System.out.println("What was the genotype for the first parent? (ex. GgTt) >>> ");
        String firstParentGenotypes = userInput.readLine();

        System.out.println("What was the genotype for the second parent? (ex. GgTt) >>> ");
        String secondParentGenotypes = userInput.readLine();

        String[] firstParentAlleles = foilGenotypes.foil(firstParentGenotypes);
        String[] secondParentAlleles = foilGenotypes.foil(secondParentGenotypes);



    }
}