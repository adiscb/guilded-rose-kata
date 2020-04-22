package items;

import java.util.Objects;

public abstract class Product {

    private Item item;

    public Product(String name, int sellin, int quality) {
        this.item = new Item(name, sellin, quality);
    }

    public static Product AgedBrie(int sellin, int quality) {
        return new AgedBrie(sellin, quality);
    }

    public static Product Standard(String name, int sellin, int quality){
        return new Standard(name, sellin, quality);
    }



    public void updateSellin() {
        item.sellIn--;
    }

    public Item getItem() {
        return item;
    }

    public void updateQuality() {
        if (hasQuality()) {
            if (hasPassed()) {
                item.quality--;
            }
            item.quality--;
        }
    }

    public boolean hasQuality() {
        return item.quality > 0;
    }

    public boolean hasPassed() {
        return item.sellIn <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(item, product.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
