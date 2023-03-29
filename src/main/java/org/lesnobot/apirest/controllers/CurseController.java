package org.lesnobot.apirest.controllers;

import org.lesnobot.apirest.dto.CurseRequest;
import org.lesnobot.apirest.services.interfaces.ICursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/curses")
public class CurseController {
    @Autowired
    private ICursesService cursesService;



    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> indexCurses() {
        return ResponseEntity.ok(this.cursesService.findAll());
    }


    @GetMapping(value = "/cursebyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findIdCurse(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.cursesService.findByCurseId(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCurse(@RequestBody CurseRequest request) {
        this.cursesService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteCurse(@PathVariable int id) {
        this.cursesService.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateCurse(@RequestBody CurseRequest request, @PathVariable int id) {
        this.cursesService.update(request, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
