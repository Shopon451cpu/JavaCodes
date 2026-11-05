package FoodDeliverySystem;

interface EarningCalculable {
    double CalculateEarning();
    default boolean isTargetReached(double target){
        return CalculateEarning()>=target;
    }
}
