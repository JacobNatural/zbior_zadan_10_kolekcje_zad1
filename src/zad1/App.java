package zad1;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var txt = "Jan;Kos;18;2000 [Komputer;Elektronika;2400 PanTadeusz;Ksiazka;120]";

        var dates = List.of("data1", "data2", "data3");

        var shop = Shopping.fromTxt(dates);
        System.out.println(shop);


    }
}
