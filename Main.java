import display.DisplayStocksCSV;
import domainmodel.Stock;
import presentation.input.InputStock;
import presentation.input.InputTrade;
import readcsv.ReadStockCsv;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("株式取引システムを開始します。");
        Path stockPath = Path.of("csv/stocks.csv");
        ReadStockCsv reader = new ReadStockCsv();
        DisplayStocksCSV displayer = new DisplayStocksCSV();
        while (true) {
            System.out.println("操作するメニューを選んでください。");
            System.out.println("A： 銘柄マスター覧表示");
            System.out.println("B： 銘柄マスタ新規登録");
            System.out.println("C： 取引入力");
            System.out.println("D： 取引一覧の表示");
            System.out.println("Q： アプリケーションを終了する");
            System.out.print("入力してください: ");
            Scanner sc = new Scanner(System.in);
            String input;
            input = sc.nextLine();
            switch (input) {
                case "A":
                    System.out.println("A: 銘柄マスタ一覧を表示します。");
                    List<Stock> stocks = reader.read(stockPath)
                    displayer.display(stocks);
                    break;
                case "B":
                    System.out.println("A: 新規銘柄マスタを追加します。");
                    InputStock.input();
                    break;
                case "C":
                    System.out.println("取引記録を追加します。");
                    InputTrade.trade();
                    break;
                case "D":
                    System.out.println("取引記録を表示します");
//                    DisplayTradeCsv.display();
                    break;
                case "Q":
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("入力が正しくありません。");
            }
        }
    }
}