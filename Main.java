import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("株式取引システムを開始します。");
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
                    ReadStockCsv.read();
                    ShowStockCsv.show();
                    break;
                case "B":
                    System.out.println("A: 新規銘柄マスタを追加します。");
                    InputStock.input();
                    break;
                case "C":
                    System.out.println("C: 取引入力");
                    InputTrade.trade();
                    break;
                case "D":
                    System.out.println("D: 取引一覧表示");
                    ShowTradeCsv.show();
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