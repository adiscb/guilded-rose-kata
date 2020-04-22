import inventory.Shop;
import items.Product;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void should_decrease_quality_and_sellin_when_update() {

        //given
        List<Product> Products = Arrays.asList(
                Product.Standard("queso", 4, 10),
                Product.Standard("luz", 4, 12)
        );
        Shop shop = new Shop(Products);

        //when
        shop.update();

        //then
        assertThat(shop).isEqualTo(new Shop(
                Arrays.asList(
                        Product.Standard("queso", 3, 9),
                        Product.Standard("luz", 3, 11)
                )
        ));

    }

    @Test
    public void should_decrease_quality_twice_when_sellin_has_passed() {

        //given
        List<Product> Products = Arrays.asList(
                Product.Standard("queso", 1, 10)
        );
        Shop shop = new Shop(Products);

        //when
        shop.update();

        //then
        assertThat(shop).isEqualTo(new Shop(
                Arrays.asList(
                        Product.Standard("queso", 0, 8)
                )
        ));
    }

    @Test
    public void quality_should_not_be_negative() {
        //given
        List<Product> Products = Arrays.asList(
                Product.Standard("queso", -5, 0)
        );
        Shop shop = new Shop(Products);

        //when
        shop.update();

        //then
        assertThat(shop).isEqualTo(new Shop(
                Arrays.asList(
                        Product.Standard("queso", -6, 0)
                )
        ));
    }

    @Test
    public void should_increase_quality_when_Product_name_is_Aged_Brie() {
        //given
        List<Product> Products = Arrays.asList(
                Product.AgedBrie( 5, 10)
        );
        Shop shop = new Shop(Products);

        //when
        shop.update();

        //then
        assertThat(shop).isEqualTo(new Shop(
                Arrays.asList(
                        Product.AgedBrie(4, 11)
                )
        ));
    }
}
