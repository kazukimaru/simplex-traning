package validation.stock;

public class ShresIssued {
    public static boolean check(String shresIssued){
        if (!sharesIssued.matches("\\d+")){
            System.out.println("整数で入力してください");
            return true;
        }else if (!(1L <= Long.parseLong(sharesIssued) && Long.parseLong(sharesIssued) <= 999999999999L)){
            System.out.println("入力した数値が規則を満たしていません。");
            return true;
        }

    }
}
