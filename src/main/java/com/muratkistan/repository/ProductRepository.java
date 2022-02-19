package com.muratkistan.repository;

import com.muratkistan.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
