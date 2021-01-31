
package com.ivan.app.datasource;

import com.ivan.app.datasource.entity.UserEntity;
import java.util.Optional;


public interface UserDao {
    
    Optional<UserEntity> selectUserByUsername(String username);
    
    void insertUser(UserEntity user);
    
    void deleteUserByUsername(String username);
    
}
