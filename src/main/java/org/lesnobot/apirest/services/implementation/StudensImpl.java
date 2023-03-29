package org.lesnobot.apirest.services.implementation;

import org.lesnobot.apirest.dto.StudenRequest;
import org.lesnobot.apirest.dto.StudensDTO;
import org.lesnobot.apirest.entities.Studens;
import org.lesnobot.apirest.repository.StudensRepository;
import org.lesnobot.apirest.services.interfaces.IStudensService;
import org.lesnobot.apirest.utils.hash.BCrypt;
import org.lesnobot.apirest.utils.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudensImpl implements IStudensService {
    @Autowired
    private StudensRepository studensRepository;

    @Override
    public List<StudensDTO> findAll() {
        List<StudensDTO> dto = new ArrayList<>();
        Iterable<Studens> studens = this.studensRepository.findAll();
        for (Studens studen :
             studens) {
            StudensDTO studensDTO = MHelpers.modelMapper().map(studen, StudensDTO.class);
            dto.add(studensDTO);
        }
        return dto;
    }

    @Override
    public List<StudensDTO> findAllByLastname(String lastname) {
        List<StudensDTO> dto = new ArrayList<>();
        Iterable<Studens> studens = this.studensRepository.findAllByLname(lastname);
        for (Studens studen :
                studens) {
            StudensDTO studensDTO = MHelpers.modelMapper().map(studen, StudensDTO.class);
            dto.add(studensDTO);
        }
        return dto;
    }

    @Override
    public StudensDTO findByUserName(String username) {
        Optional<Studens> studens = this.studensRepository.findByUserName(username);
        if (!studens.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(studens.get(), StudensDTO.class);
    }

    @Override
    public StudensDTO findByStudenId(int studenId) {
        Optional<Studens> studens = this.studensRepository.findById(studenId);
        if (!studens.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(studens.get(), StudensDTO.class);
    }

    @Override
    public void save(StudenRequest studen) {
        Studens studens = MHelpers.modelMapper().map(studen, Studens.class);
        studens.setPassword(BCrypt.hashpw(studen.getPassword(), BCrypt.gensalt()));
        this.studensRepository.save(studens);
    }

    @Override
    public void update(StudenRequest request, int userId) {
        Optional<Studens> studens = this.studensRepository.findById(userId);
        Studens studen = studens.get();
        studen.setFname(request.getFname());
        studen.setLname(request.getLname());
        studen.setUserName(request.getUsername());
        if (!request.getPassword().isEmpty()) studen.setPassword(BCrypt.hashpw(studen.getPassword(), BCrypt.gensalt()));
        this.studensRepository.save(studen);
    }

    @Override
    public void saveAll(List<StudenRequest> studens) {
        List<Studens> s = new ArrayList<>();

        for (StudenRequest studen: studens) {
            Studens st = MHelpers.modelMapper().map(studen, Studens.class);
            s.add(st);
        }
        this.studensRepository.saveAll(s);
    }

    @Override
    public void deleteById(int studenId) {
        this.studensRepository.deleteById(studenId);
    }

    private StudensDTO convertStudensDTO(final Studens studens) {
        return MHelpers.modelMapper().map(studens, StudensDTO.class);
    }
}
