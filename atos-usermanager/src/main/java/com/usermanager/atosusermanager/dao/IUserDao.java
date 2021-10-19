package com.usermanager.atosusermanager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.usermanager.atosusermanager.entity.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long> {

}
