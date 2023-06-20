package ge.restaurant.repository;

import ge.restaurant.dto.CommentDto;
import ge.restaurant.models.AverageRating;
import ge.restaurant.models.Rating;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(e.generalRating) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.generalRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    Float averageRatingBy(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT AVG(e.ambienceRating) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.ambienceRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    Float averageAmbienceRating(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT AVG(e.foodRating) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.foodRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    Float averageFoodRating(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT AVG(e.priceRating) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.priceRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    Float averagePriceRating(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT AVG(e.serviceRating) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.serviceRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    Float averageServiceRating(@Param("restaurant") Restaurant restaurant);


    @Query("SELECT COUNT(e) FROM Rating e WHERE e.comment IS NULL AND e.restaurant = :restaurant AND e.user.user_id <> 1")
    int countRowsWithCommentNullAndUserIdNotOne(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT count(e) FROM Rating e WHERE e.restaurant = :restaurant" +
            " AND e.serviceRating IS NOT NULL " +
            " AND e.user.user_id <> 1")
    int averageRatingRow(@Param("restaurant") Restaurant restaurant);

    @Query("Select r from AverageRating  r order by r.averageRating desc limit 10")
    List<AverageRating> getTopTen();

    @Query("select new ge.restaurant.dto.CommentDto(e.comment,e.user)from Rating e where e.restaurant=:restaurant and e.comment is not null ")
    List<CommentDto> findCommentsByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Query("Select r.user.user_id," +
            "r.restaurant.restaurant_id,r.generalRating" +
            " from Rating r where r.comment is  null ")
    List<Object[]> allUserRating();

    @Query("Select count(r)>0 from Rating  r where r.user.user_id=:id")
    boolean isExist(Long id);
}
