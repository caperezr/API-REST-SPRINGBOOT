package org.lesnobot.apirest.controllers;

import org.lesnobot.apirest.dto.StudenRequest;
import org.lesnobot.apirest.services.interfaces.IStudensService;
import org.lesnobot.apirest.utils.exceptions.ApiUnprocessableEntity;
import org.lesnobot.apirest.validator.StudenValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudensService studensService;

    @Autowired
    private StudenValidatorImpl studenValidator;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok(this.studensService.findAll());
    }


    @GetMapping(value = "/allbylastname/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> allbylastname(@PathVariable("lastname") String lastname) {

        return ResponseEntity.ok(this.studensService.findAllByLastname(lastname));
    }

    @GetMapping(value = "/byusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(this.studensService.findByUserName(username));
    }

    @GetMapping(value = "/byid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByStudenId(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.studensService.findByStudenId(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveStuden(@RequestBody StudenRequest request) throws ApiUnprocessableEntity {
        this.studenValidator.validator(request);
        this.studensService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/{userId}/delete")
    public ResponseEntity<Object> deleteStuden(@PathVariable int userId) {
        this.studensService.deleteById(userId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/{userId}/update")
    public ResponseEntity<Object> updateStudent(@RequestBody StudenRequest request, @PathVariable int userId) {
        this.studensService.update(request, userId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
