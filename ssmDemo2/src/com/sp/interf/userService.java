/**
 * 
 */
package com.sp.interf;
import java.util.List;

import com.sp.annotation.MyBatisRepository;
import com.sp.entity.User;
/**
 * @author hj-shui17
 *
 */
@MyBatisRepository
public interface userService {
	List<User> findAll(int page,Object obj);
    User findById(String  id);
    void deleteById(int  id);
    void addUser(User user);
    void updateUser(User user);
}
