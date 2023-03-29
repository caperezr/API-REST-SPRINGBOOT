package org.lesnobot.apirest.services.implementation;

import org.lesnobot.apirest.dto.TeacherRequest;
import org.lesnobot.apirest.dto.TeachersDTO;
import org.lesnobot.apirest.entities.Teachers;
import org.lesnobot.apirest.repository.TeachersRepository;
import org.lesnobot.apirest.services.interfaces.ITeachersService;
import org.lesnobot.apirest.utils.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class TeachersImpl implements ITeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public List<TeachersDTO> findAll() {
        List<TeachersDTO> dto = new ArrayList<>();
        Iterable<Teachers> teachers = this.teachersRepository.findAll();
        for (Teachers teacher :
                teachers) {
            TeachersDTO teacherDTO = MHelpers.modelMapper().map(teacher, TeachersDTO.class);
            dto.add(teacherDTO);
        }
        return dto;
    }



    @Override
    public TeachersDTO findByTeacherId(int idTeacher) {
        Optional<Teachers> teachers = this.teachersRepository.findById(idTeacher);
        if (!teachers.isPresent()) return null;
        return MHelpers.modelMapper().map(teachers.get(), TeachersDTO.class);
    }

    @Override
    public void save(TeacherRequest teacher) {
        Teachers teachers = MHelpers.modelMapper().map(teacher, Teachers.class);
        this.teachersRepository.save(teachers);
    }

    //Tenamos que revisar las interfaces para guardar este punto
    @Override
    public void update(TeacherRequest request, int idTeacher) {
        Optional<Teachers> teachers = this.teachersRepository.findById(idTeacher);
        Teachers teacher = teachers.get();
        teacher.setFirstNameTeacher(request.getFirstNameTeacher());
        teacher.setLastNameTeacher(request.getLastNameTeacher());
        teacher.setDniTeacher(request.getDniTeacher());
        teacher.setAgeTeacher(request.getAgeTeacher());
        this.teachersRepository.save(teacher);
    }

    @Override
    public void deleteById(int idTeacher) {
        this.teachersRepository.deleteById(idTeacher);
    }

    private TeachersDTO convertTeachersDTO(final Teachers teachers) {
        return MHelpers.modelMapper().map(teachers, TeachersDTO.class);
    }
}
