package org.lesnobot.apirest.repository;

import org.lesnobot.apirest.entities.Studens;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudensRepository extends CrudRepository<Studens, Integer> {
    @Transactional(readOnly = true)
    Optional<Studens> findByUserName(String username);

    @Transactional(readOnly = true)
    List<Studens> findAllByLname(String lastname);




}
