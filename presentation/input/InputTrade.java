package presentation.input;

import domainmodel.Trade;
import readcsv.ReadTradeCsv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class InputTrade {
    public static void trade(){
        Scanner sc = new Scanner(System.in);
        LocalDateTime tradedDatetime;
        String ticker;
        String side;
        int quantity;
        BigDecimal tradedUnitPrice;

        Path newPath = Path.of("csv/stocks.csv");
        Path tradePath = Path.of("csv/trades.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(
                tradePath, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND)){

            while (true) {
                System.out.println("銘柄コードを入力してください: ");
                try {
                    ticker = sc.nextLine();
                    boolean exist = false; // ← 重複フラグ
                    for (String line : Files.readAllLines(newPath)) {
                        if (line.startsWith(ticker + ",")) {
                            exist = true; // ← 重複フラグ
                            break;
                        }
                    }
                    if (!exist) {
                        System.out.println("銘柄コードがありません。");
                        continue;
                    }
                }catch (NumberFormatException e){
                    System.out.println("数字を入力してください");
                    continue;
                }
                break;

            }
            while (true) {
                System.out.println("取引日時を入力してください。例）2025/05/05 10:05");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                try{
                    tradedDatetime = LocalDateTime.
                            parse(sc.nextLine(),formatter);
                    //未来禁止
                    if (tradedDatetime.isAfter(LocalDateTime.now())){
                        System.out.println("過去の日時を入力してください。");
                        continue;
                    }

                    //土日のみ
                    DayOfWeek day = tradedDatetime.getDayOfWeek();
                    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
                        System.out.println("「土・日」意外を入力してください。");
                        continue;
                    }

                    //時間帯チェク
                    LocalTime time = tradedDatetime.toLocalTime();
                    if (time.isBefore(LocalTime.of(9,0)) || time.isAfter(LocalTime.of(15,30))){
                        System.out.println("9:00~15:30の間で入力してください");
                        continue;
                    }
                    //入力形式チェック
                }catch (Exception e){
                    System.out.println("入力形式が異なります。例）2025/05/05 17:05");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("売買区分を「sell・buy」で入力してください。");
                side = sc.nextLine();
                if (side.equals("sell") || side.equals("buy")){
                    break;
                }
                System.out.println("入力形式が異なります。「sell・buy」どちらかで入力してください。");
            }
            while (true) {
                System.out.println("取引数量を教えてください。");
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity < 1) {
                        System.out.println("1以上の整数で入力してください");
                        continue;
                    }
                    List<Trade> trades = ReadTradeCsv.read();

                    // 🔹 現在の保有株数を計算
                    int currentHolding = 0;
                    for (Trade t : trades) {
                        if (t.getTicker().equals(ticker)) {
                            if (t.getSide().equals("BUY")) currentHolding += t.getQuantity();
                            else if (t.getSide().equals("SELL")) currentHolding -= t.getQuantity();
                        }
                    }
                    // 🔹 売却チェック
                    if (side.equals("SELL") && quantity > currentHolding) {
                        System.out.println("❌ 売却数量が保有数を超えています！現在の保有数: " + currentHolding);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("数字を入力してください");
                    continue;
                }
                break;
            }

            while (true) {
                System.out.println("取引単価を入力してください: ");
                try {
                    tradedUnitPrice = new BigDecimal(sc.nextLine());
                    tradedUnitPrice = tradedUnitPrice.setScale(2, RoundingMode.HALF_UP);
                    if (tradedUnitPrice.compareTo(BigDecimal.ZERO) <= 0){
                        System.out.println("1以上の整数で入力してください");
                        continue;
                    }

                }catch (NumberFormatException e) {
                    System.out.println("数字を入力してください");
                    continue;
                }
                break;
            }

            LocalDateTime inputDatetime = LocalDateTime.now();
            Trade trade = new Trade(
                    tradedDatetime,
                    ticker,
                    side,
                    quantity,
                    tradedUnitPrice,
                    inputDatetime
            );

            if (Files.size(tradePath) == 0){
                writer.write(trade.toCsvRow());
                writer.newLine();
            }
            writer.write(trade.toCsvRow());
            writer.newLine();
        }
        catch (IOException e) {
            System.out.println("ファイルへの書き込みが失敗しました。");
        }
    }

}