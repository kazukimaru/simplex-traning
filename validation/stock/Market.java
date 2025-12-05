package validation.stock;

public class Market {
    public static boolean check(String market){
        if (!(market.equals("P") || market.equals("S") || market.equals("G"))){
            System.out.println("P・S・Gのいずれかを入力してください。");
            return true;
        }
        return false
    }
}
