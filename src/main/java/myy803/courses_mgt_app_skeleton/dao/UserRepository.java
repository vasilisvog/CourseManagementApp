package myy803.courses_mgt_app_skeleton.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import myy803.courses_mgt_app_skeleton.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
    
    public User findById(int id);
    //Repository for user to implement the query

  

   
	
}