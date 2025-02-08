package com.springmicroservices.users_service.repository;

import com.springmicroservices.users_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<User,Long> {
}
