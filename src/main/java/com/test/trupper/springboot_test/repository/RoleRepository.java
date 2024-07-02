package com.test.trupper.springboot_test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.trupper.springboot_test.entities.Role;
import com.test.trupper.springboot_test.model.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(UserRoles name);
}
