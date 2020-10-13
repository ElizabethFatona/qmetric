package kata.supermarket;

import java.math.BigDecimal;


public class DiscountManager {

    public static boolean isDiscountApplicable(Item anItem, Discount aDiscount){
        return aDiscount.getApplicableItems().contains(anItem);
    }

    public static void applyBuyOneGetOneFreeDiscount(Basket basket, Discount discount, BigDecimal itemPrice){

        int noDiscountItems = 0;

        if(basket.items().size() > 1){

            if(basket.items().size() % 2 ==0){
                noDiscountItems = basket.items().size() / 2;
            } else {
                noDiscountItems = (basket.items().size() - 1) / 2;
            }

            basket.getCalculator().setDiscount(itemPrice.multiply(BigDecimal.valueOf(noDiscountItems)));
        }
    }

}
