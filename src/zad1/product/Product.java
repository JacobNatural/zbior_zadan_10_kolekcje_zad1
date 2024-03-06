package zad1.product;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final String category;
    private final BigDecimal price;

    public Product(String name, String category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(String[] strData){
        this.name = strData[0];
        this.category = strData[1];
        this.price = new BigDecimal(strData[2].replaceAll("]",""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(category, product.category)) return false;
        return Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
