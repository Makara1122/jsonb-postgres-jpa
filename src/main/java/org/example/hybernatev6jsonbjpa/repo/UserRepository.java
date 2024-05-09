package org.example.hybernatev6jsonbjpa.repo;

import org.example.hybernatev6jsonbjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    @Query(value = "SELECT * FROM users_tbl u WHERE u.user_name ->> 'city' = :city", nativeQuery = true)
    List<User> findByCityInUserName(@Param("city") String city);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users_tbl SET user_name = jsonb_set(user_name, '{zipCode}', to_jsonb(:zipCode)) WHERE id = :id", nativeQuery = true)
    void updateZipCode(@Param("zipCode") String zipCode, @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_tbl WHERE user_name ->> 'city' = :city", nativeQuery = true)
    void deleteById(@Param("city") String city);
}
