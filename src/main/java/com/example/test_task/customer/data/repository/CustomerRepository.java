package com.example.test_task.customer.data.repository;

import com.example.test_task.customer.data.entity.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET is_active = :isActive WHERE id = :id", nativeQuery = true)
    void markInactive(@Param("id") Long id, @Param("isActive") boolean isActive);
}