package zad1;

import zad1.client.Client;
import zad1.product.Product;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Shopping {
    private final Map<Client, Map<Product, Integer>> shops;
    public Shopping(Map<Client, Map<Product, Integer>> shops) {
        this.shops = shops;
    }

    public static Shopping fromTxt(List<String> nameTxtList){

        var  shopFromTxt = new HashMap<Client, Map<Product, Integer>>();


        //Jan;Kos;18;2000 [Komputer;Elektronika;2400 Pan Tadeusz;Ksiazka;120]
        for(var line : nameTxtList) {
            try (var lines = Files.lines(Paths.get(line))) {
                lines.forEach(
                        lin ->{

                            var splitLine = lin.split(" \\[");
                            var clientStr = splitLine[0].split(";");

                            var client = new Client(clientStr);

                            var products = splitLine[1].split(" ");

                            for(var product: products){

                                var producutTxt = product.split(";");
                                var prod = new Product(producutTxt);

                                shopFromTxt.merge(client, new HashMap<>(Map.of(prod, 1)),
                                        Shopping::mergeMap
                                );
                            }
                        }

                );



            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        return new Shopping(shopFromTxt);

    }

    public static Map<Product, Integer> mergeMap(Map<Product, Integer> map1, Map<Product,Integer> map2){
        map2
                .entrySet()
                .stream()
                .forEach(map -> map1.merge(
                        map.getKey(),
                        1,
                        (v1, v2)-> v1 += 1
                        ));

        return map1;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner("\n");
        shops.entrySet()
                .stream()
                .forEach(map -> sj.add(map.toString()));

        return sj.toString();
    }

    // client -> (product, amount) (product, amount)



}
