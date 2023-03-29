package org.lesnobot.apirest.services.interfaces;
import org.lesnobot.apirest.dto.CurseRequest;
import org.lesnobot.apirest.dto.CursesDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ICursesService {

    List<CursesDTO> findAll();
    CursesDTO findByCurseId(int id);
    void save(CurseRequest request);
    void update(CurseRequest request, int id);
    void deleteById(int id);
}
