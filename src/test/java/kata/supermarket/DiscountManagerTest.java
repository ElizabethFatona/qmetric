package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DiscountManagerTest {

    @Test
    public void buyONoeGetOneFreeDiscountApplicableToPintOfMilk(){

        Item pintOfMilk = aPintOfMilk();

        List<Item> applicableItems = new ArrayList<>();
        applicableItems.add(pintOfMilk);

        Discount buyOneGetOneFreeDiscount = new Discount("BuyOneGetOneFree", applicableItems);

        assertTrue(buyOneGetOneFreeDiscount.getApplicableItems().contains(pintOfMilk));
        assertTrue(DiscountManager.isDiscountApplicable(pintOfMilk,buyOneGetOneFreeDiscount) == true);

    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf();
    }
}
