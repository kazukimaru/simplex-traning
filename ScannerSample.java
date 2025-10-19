import java.util.Scanner;

class ScannerSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ここにあなたの名前を入力してください>");
        String userInput = scanner.nextLine();

        String message = "Hello, " + userInput;
        System.out.println(message);
    }
}