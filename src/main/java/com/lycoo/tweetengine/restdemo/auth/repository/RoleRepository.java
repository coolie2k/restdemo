package com.lycoo.tweetengine.restdemo.auth.repository;

import com.lycoo.tweetengine.restdemo.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
