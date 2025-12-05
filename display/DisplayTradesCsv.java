//import java.text.DecimalFormat;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class DisplayTradeCsv {
//    public static void display(){
//        List<datamodel.Stock> stocks = readcsv.ReadStockCsv.read();
//
//        // ② Map を作って ticker と product_name を対応させる
//        Map<String, String> stockMap = new HashMap<>();
//        for (datamodel.Stock s : stocks) {
//            stockMap.put(s.getTicker(), s.getProductName());
//        }
//
//
//        // ③ trades.csv から取引データを読み込む
//        List<datamodel.Trade> trades = readcsv.ReadTradeCsv.read();
//
//        // ④ 表示フォーマット（日付を見やすく）
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm");
//
//        // ⑤ 取引リストを1件ずつ表示
//        DecimalFormat dfQty = new DecimalFormat("#,###");
//        DecimalFormat dfPrice = new DecimalFormat("#,##0.00");
//        System.out.println("===============================================================================================================");
//        System.out.printf("| %-16s | %-6s | %-4s | %-20s | %-20s | %-26s | %n",
//                "tradedDatetime","ticker","side","quantity","tradedUnitPrice","inputDatetime");
//        System.out.println("|------------------+--------+------+----------------------+----------------------+----------------------------|");
//        trades.sort((a, b) -> b.getTradedDatetime().compareTo(a.getTradedDatetime()));
//        for (datamodel.Trade list : trades) {
//            String productName = stockMap.getOrDefault(list.getTicker(), "（不明）");// ← ここで呼ぶ
//            System.out.printf("| %-16s | %-6s | %-4s | %-26s | %,20d | %" + "20s | %-26s  | %n",
//                    list.getTradedDatetime().format(dtf),
//                    list.getTicker(),
//                    list.getSide(),
//                    productName,
//                    list.getQuantity(),
//                    dfPrice.format(list.getTradedUnitPrice()),
//                    list.getInputDatetime().format(dtf)
//            );
//        }
//        System.out.println("===============================================================================================================");
//        System.out.println("---");
//    }
//}
