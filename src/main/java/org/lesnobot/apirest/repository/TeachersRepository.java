package org.lesnobot.apirest.repository;
import java.util.List;
import org.lesnobot.apirest.entities.Teachers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeachersRepository extends CrudRepository<Teachers, Integer> {



}
