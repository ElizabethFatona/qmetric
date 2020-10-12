package kata.supermarket;

public class DiscountManager {

    public static boolean isDiscountApplicable(Item anItem, Discount aDiscount){
        return aDiscount.getApplicableItems().contains(anItem);
    }

}
