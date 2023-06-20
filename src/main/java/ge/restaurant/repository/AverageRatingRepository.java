package ge.restaurant.repository;

import ge.restaurant.models.AverageRating;
import ge.restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AverageRatingRepository extends JpaRepository<AverageRating, Long> {
    @Modifying
    @Query("UPDATE AverageRating ar SET ar.averageRating = :averageRating WHERE ar.restaurant = :restaurant")
    void updateAverageRating(@Param("averageRating") Float averageRating, @Param("restaurant") Restaurant restaurant);

    @Modifying
    @Query("UPDATE AverageRating ar SET ar.averageRating=:averageRating, ar.averageServiceRating = :averageServiceRating, " +
            "ar.averageFoodRating = :averageFoodRating, " +
            "ar.averagePriceRating = :averagePriceRating, " +
            "ar.averageAmbienceRating = :averageAmbienceRating WHERE ar.restaurant = :restaurant")
    void updateAverageRatingsExceptAverageRating(@Param("averageServiceRating") Float averageServiceRating,
                                                 @Param("averageFoodRating") Float averageFoodRating,
                                                 @Param("averagePriceRating") Float averagePriceRating,
                                                 @Param("averageAmbienceRating") Float averageAmbienceRating,
                                                 @Param("averageRating") Float averageRating,
                                                 @Param("restaurant") Restaurant restaurant);

    @Query("SELECT ar FROM AverageRating ar ORDER BY ar.averageRating_Id DESC")
    List<AverageRating> getAllRestaurantWithAverageRating();

    @Query("SELECT r FROM AverageRating r WHERE r.averageRating >= :minRating" +
            " AND r.averageRating <= :maxRating order by  r.averageRating_Id DESC")
    List<AverageRating> findRatingsByAverageRatingRange(@Param("minRating") Float minRating,
                                                        @Param("maxRating") Float maxRating);

    @Query("SELECT r FROM AverageRating r WHERE r.restaurant.type" +
            " IN :types order by  r.averageRating_Id DESC")
    List<AverageRating> findRestaurantsByTypes(@Param("types") Set<String> types);

    @Query("Select r FROM AverageRating r WHERE r.restaurant.addresses.district IN :district")
    List<AverageRating> findRestaurantsByDistrict(@Param("district")Set<String> district);

    @Query("SELECT r FROM AverageRating r WHERE r.restaurant.type" +
            " IN :types and r.averageRating >= :minRating " +
            "and r.averageRating <= :maxRating   order by  r.averageRating_Id DESC")
    List<AverageRating> findRestaurantsByTypesAndRating(@Param("types") Set<String> types,
                                                        @Param("minRating") Float minRating,
                                                        @Param("maxRating") Float maxRating);

    @Query("SELECT r FROM AverageRating r WHERE r.restaurant.type" +
            " IN :types and  r.restaurant.addresses.district IN :distinct" +
            " order by  r.averageRating_Id DESC")
    List<AverageRating> findRestaurantsByTypesAndDistinct(@Param("types") Set<String> types,
                                                          @Param("distinct")Set<String> distinct);

    @Query("SELECT r FROM AverageRating r WHERE r.restaurant.addresses.district" +
            " IN :distinct and r.averageRating >= :minRating " +
            "and r.averageRating <= :maxRating   order by  r.averageRating_Id DESC")
    List<AverageRating> findRestaurantsByDistinctAndRating(@Param("distinct") Set<String> distinct,
                                                        @Param("minRating") Float minRating,
                                                        @Param("maxRating") Float maxRating);

    @Query("SELECT r FROM AverageRating r WHERE r.restaurant.type" +
            " IN :types and r.averageRating >= :minRating " +
            "and r.averageRating <= :maxRating and r.restaurant.addresses.district in :distinct   order by  r.averageRating_Id DESC")
    List<AverageRating> findRestaurantsByTypesAndRatingAndDistinct(@Param("types") Set<String> types,
                                                        @Param("minRating") Float minRating,
                                                        @Param("maxRating") Float maxRating,
                                                        @Param("distinct") Set<String> distinct);

    @Query("Select r from AverageRating r where r.restaurant=:restaurant")
    AverageRating findByRestaurant(@Param("restaurant")Restaurant restaurant);

    @Query("Select r from AverageRating r where r.restaurant.restaurant_id in :rest")
    Set<AverageRating> recommended(List<Long> rest);

    @Query("Select r from AverageRating  r where r.restaurant.username like %:name%")
    List<AverageRating> findByName(String name);

}
