package be.stadr.vikinglanguagecore.persist;

import be.stadr.vikinglanguagecore.domain.Translation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TranslationRepository extends CrudRepository<Translation, Integer> {

    Optional<Translation> findByLanguageCodeAndText(String languageCode, String text);

}
