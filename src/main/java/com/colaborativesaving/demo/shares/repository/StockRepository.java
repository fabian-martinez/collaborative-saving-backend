package com.colaborativesaving.demo.shares.repository;

import com.colaborativesaving.demo.shares.model.StockDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<StockDB,Long> {
    public StockDB findByUserAndShare(String user,String share);
    public List<StockDB> findByUser(String user);
    public List<StockDB> findByShare(String share);
}
