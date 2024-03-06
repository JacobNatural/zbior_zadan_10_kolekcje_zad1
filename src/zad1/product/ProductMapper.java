package zad1.product;

import java.io.File;
import java.math.BigDecimal;
import java.util.function.Function;

public interface ProductMapper {
    Function<Product, BigDecimal> toPrice = product -> product.price;
}
