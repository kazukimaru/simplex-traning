import java.util.List;

public class ShowStockCsv {
    public static void show() {
        List<Stock> stocks = ReadStockCsv.read();// ← ここで呼ぶ
        System.out.println("==========================================================================");
        System.out.printf("| %-6s | %-33s | %-8s | %-14s |%n",
                "Ticker", "Product Name", "Market", "Shares Issued");
        System.out.println("|--------+-----------------------------------+----------+----------------|");
        for (Stock list : stocks) {
            System.out.printf("| %-6s | %-33s | %-8s | %,14d |%n",
                    list.getTicker()
                    ,list.getName()
                    ,list.getMarket().getLabel()
                    ,list.getSharesIssued());
        }
        System.out.println("==========================================================================");
        System.out.println("---");
    }
}
