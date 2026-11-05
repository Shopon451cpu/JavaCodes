package FoodDeliverySystem;

 interface Rateable {
      boolean hasGoodRating();
      default String ratingStatus(){
          if (hasGoodRating()){
              return "Good Rating";
          }else{
              return "Average Rating";
          }
      }
}
