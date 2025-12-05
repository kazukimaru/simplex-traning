package validation.stock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ticker {
    public static boolean check(String ticker){
        boolean checkticker = false;
        Path path = Path.of("csv/stocks.csv");

        if (!ticker.matches("^[0-9][ACDF-HJ-NP-UWXY0-9][0-9][ACDF-HJ-NP-UWXY0-9]$")) {
            System.out.println("入力形式が異なります。");
            return true;
        }
        try {
            for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                if (line.startsWith(ticker)) {
                    checkticker = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("入力形式が異なります。");
            return true;
        }
        if (checkticker) {
            System.out.println("この銘柄コードはすでに登録されています");
            return true;
            }
        return false;
    }
}
