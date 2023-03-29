package org.lesnobot.apirest.controllers;

import net.bytebuddy.asm.Advice;
import org.lesnobot.apirest.dto.TeacherRequest;
import org.lesnobot.apirest.services.interfaces.ITeachersService;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private ITeachersService teachersService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> indexTeachers() {
        return ResponseEntity.ok(this.teachersService.findAll());
    }

    @GetMapping(value = "/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findIdTeacher(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.teachersService.findByTeacherId(id));
    }



    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveTeacher(@RequestBody TeacherRequest request) {
        this.teachersService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateTeacher(@RequestBody TeacherRequest request, @PathVariable("id") int id) {
        this.teachersService.update(request, id);
        return  ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable int id) {
        this.teachersService.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
