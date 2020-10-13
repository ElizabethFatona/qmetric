package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountManagerTest {

    public static final java.math.BigDecimal MILK_PRICE = new BigDecimal("0.49");

    private static Item aPintOfMilk() {
        return new Product(MILK_PRICE).oneOf();
    }

    @Test
    public void buyOneGetOneFreeDiscountApplicableToPintOfMilk(){

        Item pintOfMilk = aPintOfMilk();

        List<Item> applicableItems = new ArrayList<>();
        applicableItems.add(pintOfMilk);

        Discount buyOneGetOneFreeDiscount = new Discount("BuyOneGetOneFree", applicableItems);

        assertTrue(buyOneGetOneFreeDiscount.getApplicableItems().contains(pintOfMilk));
        assertTrue(DiscountManager.isDiscountApplicable(pintOfMilk,buyOneGetOneFreeDiscount) == true);

    }



    @Test
    public void applyBuyOneGetOneFreeDiscountToTwoPintsOfMilk(){

        Item pintOfMilk = aPintOfMilk();
        Item anotherPintOfMilk = aPintOfMilk();

        List<Item> basketItems = new ArrayList<>();
        basketItems.add(pintOfMilk);
        basketItems.add(anotherPintOfMilk);

        final Basket basket = new Basket();
        basketItems.forEach(basket::add);

        int noDiscountItems = 0;

        if(basketItems.size() > 1){

            if(basketItems.size() % 2 ==0){
                noDiscountItems = basketItems.size() / 2;
            } else {
                noDiscountItems = (basketItems.size() - 1) / 2;
            }

            basket.getCalculator().setDiscount(MILK_PRICE.multiply(BigDecimal.valueOf(noDiscountItems)));
        }

        assertEquals(MILK_PRICE, basket.total());

    }

}
