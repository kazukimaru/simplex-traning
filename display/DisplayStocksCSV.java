package display;

import domainmodel.Stock;
import readcsv.ReadStockCsv;

import java.util.List;

public class DisplayStocksCSV {
    public  void display(List<Stock> stocks) {
        if (stocks.isEmpty()){
            return;
        }
        System.out.println("==========================================================================");
        System.out.printf("| %-6s | %-33s | %-8s | %-14s |%n",
                "Ticker", "Product Name", "Market", "Shares Issued");
        System.out.println("|--------+-----------------------------------+----------+----------------|");

        for (Stock list : stocks) {
            System.out.printf("| %-6s | %-33s | %-8s | %,14d |%n",
                    list.getTicker(),
                    list.getProductName(),
                    list.getMarket().getLabel(),
                    list.getSharesIssued());
        }
        System.out.println("==========================================================================");
        System.out.println("---");
    }
}
