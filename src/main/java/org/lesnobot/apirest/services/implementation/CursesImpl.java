package org.lesnobot.apirest.services.implementation;
import org.lesnobot.apirest.dto.CurseRequest;
import org.lesnobot.apirest.dto.CursesDTO;
import org.lesnobot.apirest.entities.Curses;
import org.lesnobot.apirest.repository.CursesRepository;
import org.lesnobot.apirest.services.interfaces.ICursesService;
import org.lesnobot.apirest.utils.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CursesImpl implements ICursesService {
    @Autowired
    private CursesRepository cursesRepository;

    @Override
    public List<CursesDTO> findAll() {
        List<CursesDTO> dto = new ArrayList<>();
        Iterable<Curses> curses = this.cursesRepository.findAll();
        for (Curses curse :
                curses) {
            CursesDTO cursesDTO = MHelpers.modelMapper().map(curse, CursesDTO.class);
            dto.add(cursesDTO);
        }
        return dto;
    }

    @Override
    public CursesDTO findByCurseId(int id) {
        Optional<Curses> curses = this.cursesRepository.findById(id);
        if (!curses.isPresent()) return null;
        return MHelpers.modelMapper().map(curses.get(), CursesDTO.class);
    }

    @Override
    public void save(CurseRequest curse) {
        Curses curses = MHelpers.modelMapper().map(curse, Curses.class);
        this.cursesRepository.save(curses);
    }

    @Override
    public void update(CurseRequest request, int id) {
        Optional<Curses> curses = this.cursesRepository.findById(id);
        Curses curse = curses.get();
        curse.setName(request.getName());
        curse.setCredits(request.getCredits());
        this.cursesRepository.save(curse);
    }

    @Override
    public void deleteById(int id) {
        this.cursesRepository.deleteById(id);
    }

    private CursesDTO convertStudensDTO(final Curses curses) {
        return MHelpers.modelMapper().map(curses, CursesDTO.class);
    }
}
