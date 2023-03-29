package org.lesnobot.apirest.services.interfaces;

import org.lesnobot.apirest.dto.TeacherRequest;
import org.lesnobot.apirest.dto.TeachersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITeachersService {
    List<TeachersDTO> findAll();
    TeachersDTO findByTeacherId(int idTeacher);
    void save(TeacherRequest request);
    void update(TeacherRequest request, int idTeacher);
    void deleteById(int idTeacher);


}
