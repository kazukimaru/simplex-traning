package presentation.input;

import validation.stock.ProductName;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static java.lang.String.join;

public class InputStock {
    public static void input(){
       try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
           Scanner sc = new Scanner(System.in);
           System.out.println("新しい株式銘柄を登録します");
           String productName = "";
           String ticker;
           String market;
           String sharesIssued;
           boolean check = true;

           while (true) {
               System.out.println("銘柄名を入力してください");
               productName = sc.nextLine();
               check = ProductName.check(productName);
               if (check){
               }
               else if (!check){
                   break;
               }
           }

            while (true){
                System.out.println("上場区分を入力してください");
                market = sc.nextLine();
                check = ProductName.check(market);
                if (check){
                }
                else if (!check){
                    break;
                }
           }
            while (true){
                System.out.println("発行株式枚数を入力してください");
                sharesIssued = sc.nextLine();

           }

           writer.newLine();
           writer.append(join(",",ticker,productName,market,sharesIssued));
           System.out.println(productName + "を新規銘柄として登録しました。");
           System.out.println("---");
       }catch (IOException e){
           System.out.println("ファイルパスがありません。");
       }
    }
}
