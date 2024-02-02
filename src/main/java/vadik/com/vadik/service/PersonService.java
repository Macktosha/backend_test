package vadik.com.vadik.service;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vadik.com.vadik.entity.PersonEntity;
import vadik.com.vadik.model.PersonModel;
import vadik.com.vadik.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
    @Resource
    private final PersonRepository repository;

    @Transactional
    public PersonEntity addPerson(PersonEntity personEntity){
        return repository.save(personEntity);
    }

    public PersonEntity findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not exist with id :" + id));
    }

    public PersonEntity save(PersonEntity personEntity){
        return repository.save(personEntity);
    }

    public void delete(PersonEntity personEntity){
         repository.delete(personEntity);
    }


    public List<PersonModel> findByAgeGreaterThanValue(Integer age){
        var result = repository.findByAge(age);
        List<PersonModel> personModels = new ArrayList<>();

        log.info(personModels.toString());
        return personModels;
    }

    @Transactional
    public PersonEntity findByName(String name){
       return repository.findByName(name);
    }


}
