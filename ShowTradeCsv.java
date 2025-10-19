import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ShowTradeCsv {
    public static void show(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        List<Trade> trades = ReadTradeCsv.read();// ← ここで呼ぶ
        System.out.println("===============================================================================================================");
        System.out.printf("| %-16s | %-6s | %-4s | %-20s | %-20s | %-26s | %n",
                "tradedDatetime","ticker","side","quantity","tradedUnitPrice","inputDatetime");
        System.out.println("|------------------+--------+------+----------------------+----------------------+----------------------------|");
        for (Trade list : trades) {
            System.out.printf("| %-16s | %-6s | %-4s | %,20d | %" + "20s | %-26s | %n",
                    list.getTradedDatetime(),list.getTicker(),list.getSide(),list.getQuantity(),df.format(list.getTradedUnitPrice()),list.getInputDatetime());
        }
        System.out.println("===============================================================================================================");
        System.out.println("---");
    }
}
