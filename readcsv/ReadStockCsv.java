package readcsv;

import domainmodel.Stock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadStockCsv {
    public List<Stock> read(Path path){
        boolean isheader = true;
        String[] header = {"ticker","product_name","market","shares_issued"};

        List<Stock> stocks = new ArrayList<>();
        try{
            for (String lines : Files.readAllLines(path, StandardCharsets.UTF_8)){
                if (isheader){
                    String[] headerline  = lines.split(",");
                    if (headerline.length != 4) {
                        System.out.println("列数が異なります");
                        return new ArrayList<>();
                    }
                    if (!Arrays.equals(header,headerline)){
                        System.out.println("ファイル列順序が異なります。");
                        return new ArrayList<>();
                    }
                    isheader = false;
                    continue;
                }
                String[] line  = lines.split(",");
                stocks.add(new Stock(line));
            }

        } catch (IOException e) {
            System.out.println("データが読み込めません。");
        }
        return stocks;
    }
}
