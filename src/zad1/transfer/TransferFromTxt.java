package zad1.transfer;

import zad1.Shopping;
import zad1.client.Client;
import zad1.product.Product;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferFromTxt {

    private final Map<Client, Map<Product, Integer>> map;
    private final List<String> dataList;

    public TransferFromTxt(List<String> dataList) {
        this.map = new HashMap<>();
        this.dataList = dataList;
    }

    public Map<Client, Map<Product, Integer>> getDataFromTxt(String regex){

        for(var line : dataList) {
            try (var lines = Files.lines(Paths.get(line))) {
                lines.forEach(
                        lin ->
                            parseLine(lin, regex)
                );
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return map;
    }

    public void parseLine(String line, String regex) {
        if (!line.matches(regex)) {
            throw new IllegalArgumentException("Line is wrong");
        }


        var splitLine = line.split(" \\[");
        var clientStr = splitLine[0].split(";");
        var client = new Client(clientStr);

        var products = splitLine[1].split(" ");

        for (var product : products) {

            var producutTxt = product.split(";");
            var prod = new Product(producutTxt);

            map.merge(client, new HashMap<>(Map.of(prod, 1)),
                    this::mergeMap
            );


        }
    }
    public Map<Product, Integer> mergeMap(Map<Product, Integer> map1, Map<Product,Integer> map2){
        map2
                .forEach((key, value) -> map1.merge(
                        key,
                        1,
                        (v1, v2) -> v1 += 1
                ));

        return map1;
    }
}
