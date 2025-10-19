import java.util.Scanner;

class ScannerAsk {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("ご用件はなんでしょうか？>");
		String userInput = scanner.nextLine();
		System.out.println("ご用件は"+"\""+userInput+"\""+"ですね。");
	}
}