package com.colaborativesaving.demo.shares.repository;

import com.colaborativesaving.demo.shares.model.UserStock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<UserStock,Long> {
    public UserStock findByUserIdAndShareId(long user, long share);
    public List<UserStock> findByUserId(long user);
    public List<UserStock> findByShareId(long share);
}
