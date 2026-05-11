package com.userservice.repository;

import com.userservice.entities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfoDto, String> {
    Optional<UserInfoDto> findByUserId(String userId);
}
