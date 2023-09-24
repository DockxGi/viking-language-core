package be.stadr.vikinglanguagecore.persist;

import be.stadr.vikinglanguagecore.domain.Translation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TranslationRepository extends CrudRepository<Translation, Integer> {

    Optional<Translation> findByLanguageCodeAndText(String languageCode, String text);

    @Query(nativeQuery = true, value = "select * from translation t inner join word_translation wt on t.id = wt.translation_id and wt.word_id = :wordId")
    List<Translation> findByWordId(@Param("wordId") int wordId);
}
