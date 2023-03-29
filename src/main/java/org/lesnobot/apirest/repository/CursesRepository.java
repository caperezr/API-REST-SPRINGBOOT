package org.lesnobot.apirest.repository;
import org.lesnobot.apirest.entities.Curses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import java.util.List;

@Repository
public interface CursesRepository extends CrudRepository<Curses, Integer> {
    @Transactional(readOnly = true)
    Optional<Curses> findByName(String name);

    @Transactional(readOnly = true)
    List<Curses> findAllByCredits(int credits);
}
