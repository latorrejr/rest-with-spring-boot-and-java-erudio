package br.com.alatorre;

import br.com.alatorre.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Ademar");
        person.setLastName("Latorre");
        person.setGender("Male");
        person.setAddress("Curitiba - PR");
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("PrimeiroNome"+String.valueOf(i));
        person.setLastName("UltimoNome"+String.valueOf(i));
        if(i%2 == 1)
            person.setGender("Male");
        else
            person.setGender("Female");
        person.setAddress("Endereço"+String.valueOf(i));
        return person;
    }

}
