package be.stadr.vikinglanguagecore.persist;

import be.stadr.vikinglanguagecore.domain.Verb;
import be.stadr.vikinglanguagecore.domain.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Integer> {

    Verb findByIdAndType(int id, int type);

}
