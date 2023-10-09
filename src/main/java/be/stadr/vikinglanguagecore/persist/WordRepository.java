package be.stadr.vikinglanguagecore.persist;

import be.stadr.vikinglanguagecore.domain.Verb;
import be.stadr.vikinglanguagecore.domain.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM word WHERE id = :id AND type = :type")
    Verb findByIdAndType(int id, int type);

    Iterable<Word> findAllByMostFrequentInSagas(boolean mostFrequentInSagas);
}
