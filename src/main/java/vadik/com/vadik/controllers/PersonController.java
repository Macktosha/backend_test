package vadik.com.vadik.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadik.com.vadik.entity.PersonEntity;
import vadik.com.vadik.model.PersonModel;
import vadik.com.vadik.service.PersonService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> getById(@PathVariable int id) {
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/byage")
    public ResponseEntity<List<PersonModel>> getByAge(@RequestParam Integer age){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.findByAgeGreaterThanValue(age));
    }

    @GetMapping("/byname")
    public ResponseEntity<String> getByName(@RequestParam String name){
        PersonEntity body = personService.findByName(name);
        log.info(body.toString());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body.toString());
    }

    @PostMapping("/persons")
    public PersonEntity createPerson(@RequestBody PersonModel personModel) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setAge(personModel.getAge());
        personEntity.setName(personModel.getName());
        personEntity.setEmail(personModel.getEmail());
        return personService.addPerson(personEntity);
    }

    // get employee by id rest api
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable Integer id) {
        PersonEntity employee = personService.findById(id);
        return ResponseEntity.ok(employee);
    }

    // update employee rest api

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonModel> updateEmployee(@PathVariable Integer id, @RequestBody PersonModel personModel){
        PersonEntity personEntity = personService.findById(id);
        personEntity.setAge(personModel.getAge());
        personEntity.setEmail(personModel.getEmail());
        personEntity.setName(personModel.getName());
        personService.save(personEntity);

        return ResponseEntity.ok(personModel);
    }

    // delete employee rest api
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
        PersonEntity personEntity = personService.findById(id);

        personService.delete(personEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
