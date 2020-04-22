package items;

public class AgedBrie extends Product {

    public AgedBrie(int sellin, int quality) {
        super("Aged Brie", sellin, quality);
    }

    @Override
    public void updateQuality() {
        super.getItem().quality++;
    }
}
