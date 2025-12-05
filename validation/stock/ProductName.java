package validation.stock;

public class ProductName {
    public static boolean check(String productName){
            if (productName.trim().isEmpty()){
                System.out.println("文字を入力してください。");
                return true;
            }else if (!productName.matches("[A-Za-z0-9 .()]+")) {
                System.out.println("入力形式が異なります。");
                return true;
            }else
            return false;
    }
}
