package vadik.com.vadik.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonModel {

    private String name;
    private Integer age;
    private String email;


    public PersonModel(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
