package eu.makdeniss.mapper;

import eu.makdeniss.domain.Person;
import eu.makdeniss.domain.PersonDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */

@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper {

    PersonDTO personToPersonDTO(Person person);

    List<PersonDTO> peopleToPeopleDTOs(List<Person> people);

    Person personDTOToPerson(PersonDTO personDTO);

    List<Person> peopleDTOsToPeople(List<PersonDTO> peopleDTOs);

}
