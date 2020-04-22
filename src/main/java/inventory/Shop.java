package inventory;

import items.Item;
import items.Product;

import java.util.List;
import java.util.Objects;

public class Shop {

    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update() {
        for (Product product: products) {
            updateInventory(product);
        }
    }

    private void updateInventory(Product product) {
        product.updateSellin();
        product.updateQuality();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(products, shop.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String
    toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }
}
