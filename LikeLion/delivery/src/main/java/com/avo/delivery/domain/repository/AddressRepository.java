package com.avo.delivery.domain.repository;

import com.avo.delivery.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select r from Address r where r.user.id = :userId")
    Address findByAllUserId(Long userId);
}
