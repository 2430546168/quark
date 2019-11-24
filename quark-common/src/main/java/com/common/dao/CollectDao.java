package com.common.dao;

import com.common.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectDao extends JpaRepository<Collect, Integer> {
}
