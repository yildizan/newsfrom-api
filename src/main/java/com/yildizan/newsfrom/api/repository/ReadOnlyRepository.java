package com.yildizan.newsfrom.api.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);

}
