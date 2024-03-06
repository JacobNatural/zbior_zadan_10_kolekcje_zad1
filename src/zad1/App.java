package zad1;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        var dates = List.of("data1", "data2", "data3");

        var shop = Shopping.fromTxt(dates, "[A-Z][a-z]+;[A-Z][a-z]+;[1-9][0-9]*;[1-9][0-9]* " +
                "\\[([a-zA-Z_]+;[a-zA-Z_]+;[1-9][0-9]* )" +
                "*[a-zA-Z_]+;[a-zA-Z_]+;[1-9][0-9]*\\]");
        System.out.println(shop);
        System.out.println("----------------------------------");
        System.out.println("Client with higher bill");
        System.out.println(shop.getClientHigherBill());
    }
}
