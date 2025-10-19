import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReadTradeCsv {
    public static List<Trade> read(){
        List<Trade> trades = new ArrayList<>();
        Path tradePath = Path.of("trades.csv");
        String header = "tradedDatetime,ticker,side,quantity,tradedUnitPrice,inputDatetime";
        boolean isheader = true;
        try {
            for (String line : Files.readAllLines(tradePath)) {
                if (isheader){
                    if (!header.equals(line)){
                        System.out.println("ファイル列順序が異なります。");
                        return new ArrayList<>();
                    }
                    isheader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length != 6) {
                    System.out.println("列数が異なります: " );
                    return new ArrayList<>();
                }

                //型変形させる
                LocalDateTime tradedDatetime = LocalDateTime.parse(data[0]);
                String ticker = data[1];
                String side = data[2];
                int quantity = Integer.parseInt(data[3]);
                BigDecimal tradedUnitPrice = new BigDecimal(data[4]);
                LocalDateTime inputDatetime = LocalDateTime.parse(data[5]);

                //tradesリストに追加
                trades.add(new Trade(tradedDatetime,ticker,side,quantity,tradedUnitPrice,inputDatetime));
            }
        } catch (IOException e) {
            System.out.println("ファイルが見つかりません: " + e.getMessage());
        }
        trades.sort((a, b) -> a.getTradedDatetime().compareTo(b.getTradedDatetime()));
        return trades;
    }
}
