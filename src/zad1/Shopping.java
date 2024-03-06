package zad1;

import zad1.client.Client;
import zad1.product.Product;
import zad1.transfer.TransferFromTxt;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Shopping {
    private final Map<Client, Map<Product, Integer>> shops;
    public Shopping(Map<Client, Map<Product, Integer>> shops) {
        this.shops = shops;
    }

    public static Shopping fromTxt(List<String> nameTxtList, String regex){

        var fromTxt = new TransferFromTxt(nameTxtList);
        return new Shopping(fromTxt.getDataFromTxt(regex));
    }



    @Override
    public String toString() {
        var sj = new StringJoiner("\n");
        shops.entrySet()
                .forEach(map -> sj.add(map.toString()));

        return sj.toString();
    }

    // client -> (product, amount) (product, amount)



}
