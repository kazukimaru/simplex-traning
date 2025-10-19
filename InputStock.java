import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputStock {
    public static void input(){
        Path newPath = Path.of("stocks.csv");
        Scanner sc = new Scanner(System.in);
        try(BufferedWriter writer = Files.newBufferedWriter(newPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            // 変数をループの外で宣言
            String productName = "";
            String ticker = "";
            String market = "";
            String sharesIssued = "";

            while (true) {
                System.out.println("銘柄名を入力してください: ");
                productName = sc.nextLine();
                if (productName.trim().isEmpty()){
                    System.out.println("銘柄名が空白です。");
                }else if (!productName.matches("[A-Za-z0-9 .()]+")) {
                    System.out.println("入力形式が異なります。");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("銘柄コードを入力してください: ");
                ticker = sc.nextLine();
                if (!ticker.matches("^[0-9][A-DF-HJ-NPR-UWXY0-9][0-9][A-DF-HJ-NPR-UWXY0-9]$")) {
                    System.out.println("入力形式が異なります。");
                    continue;
                }
                boolean duplicate = false; // ← 重複フラグ
                for (String line : Files.readAllLines(newPath)) {
                    if (line.startsWith(ticker + ",")) {
                        System.out.println("この銘柄コードは既に登録されています。");
                        duplicate = true; // ← 重複ありを記録
                        break;            // ← 無駄にforを回さないように抜ける
                    }
                }
                if (duplicate) {
                    continue; // ← whileの最初に戻って再入力
                }

                break;
            }
            while (true) {
                System.out.println("上場市場を入力してください: ");
                market = sc.nextLine();
                if (!(market.equals("P") || market.equals("S") || market.equals("G"))){
                    System.out.println("該当の市場はありません。");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("発行済み株式数を入力してください: ");
                sharesIssued = sc.nextLine();
                if (!sharesIssued.matches("\\d+")) {
                    System.out.println("整数で入力してください（カンマや記号は不可）。");
                    continue;
                }else if (!(1L <= Long.parseLong(sharesIssued) && Long.parseLong(sharesIssued) <= 999999999999L)){
                    System.out.println("1~999,999,999,999の間で入力してください。");
                    continue;
                }
                break;
            }
            writer.newLine();
            writer.append(String.join(",",ticker,productName,market,sharesIssued));
            System.out.println(productName + "を新規銘柄として登録しました。");
            System.out.println(productName + "---");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
