package org.lesnobot.apirest.services.interfaces;

import org.lesnobot.apirest.dto.StudenRequest;
import org.lesnobot.apirest.dto.StudensDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudensService {

    List<StudensDTO> findAll();

    StudensDTO findByUserName(String username);

    List<StudensDTO> findAllByLastname(String lastname);
    StudensDTO findByStudenId(int studenId);

    void save(StudenRequest request);

    void update(StudenRequest request, int userId);
    void saveAll(List<StudenRequest> studens);
    void deleteById(int studenId);
}
