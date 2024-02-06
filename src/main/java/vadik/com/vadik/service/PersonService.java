package vadik.com.vadik.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
//    @Resource
//    private final PersonRepository repository;

//    @Transactional
//    public PersonEntity addPerson(PersonEntity personEntity){
//        return repository.save(personEntity);
//    }
//
//    public PersonEntity findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not exist with id :" + id));
//    }
//
//    public PersonEntity save(PersonEntity personEntity){
//        return repository.save(personEntity);
//    }
//
//    public void delete(PersonEntity personEntity){
//         repository.delete(personEntity);
//    }
//
//
//    public List<PersonModel> findByAgeGreaterThanValue(Integer age){
//        var result = repository.findByAge(age);
//        List<PersonModel> personModels = new ArrayList<>();
//
//        log.info(personModels.toString());
//        return personModels;
//    }


    public String findByName(String name){
        return name;
    }


}
