package lk.epic.Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import lk.epic.Backend.entity.User;

public interface UserRepo extends JpaRepository<User,String> {
     @Query(value="SELECT user_id FROM User ORDER BY user_id DESC LIMIT 1;",nativeQuery = true)
     String getLastUserId();

     @Query(value = "SELECT * FROM user WHERE user_name = ?1 AND password = ?2", nativeQuery = true)
     User checkUsernameAndPassword(String username,String password);
     
     @Query(value = "SELECT password FROM user WHERE user_name = ?1", nativeQuery = true)
     String getPassword(String username);
}
