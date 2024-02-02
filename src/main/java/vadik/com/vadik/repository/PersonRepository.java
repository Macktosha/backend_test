package vadik.com.vadik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vadik.com.vadik.entity.PersonEntity;

import java.util.List;

@Repository
public interface  PersonRepository extends JpaRepository<PersonEntity, Integer> {

     @Query("select ps from PersonEntity ps where ps.age > :age")
     List<PersonEntity> findByAge(@Param("age") Integer age);

     PersonEntity findByName(String name);


}
