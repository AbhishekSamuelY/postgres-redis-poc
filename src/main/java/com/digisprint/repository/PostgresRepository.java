package com.digisprint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digisprint.beans.Item;

@Repository
public interface PostgresRepository extends CrudRepository<Item, Integer> {

}
