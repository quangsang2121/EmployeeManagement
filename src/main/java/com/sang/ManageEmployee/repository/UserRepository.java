package com.sang.ManageEmployee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sang.ManageEmployee.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query(value="where username=?1",nativeQuery = true)
	User findByUserName(String username);
}
