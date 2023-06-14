package ge.restaurant.repository;

import ge.restaurant.dto.UserDto;
import ge.restaurant.models.Addresses;
import ge.restaurant.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

//    @Modifying
//    @Query("UPDATE Users u set u.username=:name,u.lastname=:lastname," +
//            "u.email=:email,u.phoneNumber=:phoneNumber,u.password=:password," +
//            "u.addresses=:addressesSet where u.user_id=:user_id")
//    public Users updateUser(@Param("name") String name, @Param("lastname") String lastname,
//                            @Param("email") String email, @Param("phoneNumber") String phoneNumber,
//                            @Param("password") String password,@Param("user_id") Long user_id,
//                            @Param("addressesSet") Set<Addresses> addressesSet);
}
