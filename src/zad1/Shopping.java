package zad1;

import zad1.client.Client;
import zad1.product.Product;
import zad1.product.ProductMapper;
import zad1.transfer.TransferFromTxt;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Shopping {
    private final Map<Client, Map<Product, Integer>> shops;
    public Shopping(Map<Client, Map<Product, Integer>> shops) {
        this.shops = shops;
    }

    public static Shopping fromTxt(List<String> nameTxtList, String regex){

        var fromTxt = new TransferFromTxt(nameTxtList);

        return new Shopping(fromTxt.getDataFromTxt(regex));
    }

    //Wyznacz klienta, który zapłacił najwięcej za wszystkie zakupy.

    public List<Client> getClientHigherBill(){
       return shops
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        map -> totalPrice(map.getValue())))
               .entrySet()
               .stream()
               .collect(Collectors.groupingBy(
                       Map.Entry::getValue,
                       Collectors.mapping(
                               Map.Entry::getKey,
                               Collectors.toList())))
       .entrySet()
               .stream()
               .max(Map.Entry.comparingByKey())
               .map(Map.Entry::getValue)
               .orElse(null);
    }


    public BigDecimal totalPrice(Map<Product, Integer> mapOfProduct){
        return mapOfProduct
                .entrySet()
                .stream()
                .map(map -> ProductMapper.toPrice.apply(map.getKey()).multiply(BigDecimal.valueOf(map.getValue())))
                .reduce(BigDecimal::add)
                .orElse(null);
    }





    @Override
    public String toString() {
        var sj = new StringJoiner("\n");
        shops.entrySet()
                .forEach(map -> sj.add(map.toString()));
        return sj.toString();
    }


}
