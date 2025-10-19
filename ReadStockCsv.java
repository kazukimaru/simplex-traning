import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadStockCsv {
    public static List<Stock> read(){
        List<Stock> stocks = new ArrayList<>();
        Path newPath = Path.of("stocks.csv");
        String header = "ticker,product_name,market,shares_issued";
        boolean isheader = true;
        try {
            for (String line : Files.readAllLines(newPath)) {
                if (isheader){
                    if (!header.equals(line)){
                        System.out.println("ファイル列順序が異なります。");
                        return new ArrayList<>();
                    }
                    isheader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length != 4) {
                    System.out.println("列数が異なります: " );
                    return new ArrayList<>();
                }
                stocks.add(new Stock(data));
            }
        } catch (IOException e) {
            System.out.println("ファイルが見つかりません: " + e.getMessage());
        }
        return stocks;
    }
}
