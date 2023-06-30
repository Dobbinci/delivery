package com.avo.delivery.domain.repository;

import com.avo.delivery.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
