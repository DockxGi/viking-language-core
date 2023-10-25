package be.stadr.vikinglanguagecore.domain;

import be.stadr.vikinglanguagecore.utils.StringValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.Validate;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static be.stadr.vikinglanguagecore.utils.StringValidator.length;
import static javax.persistence.GenerationType.AUTO;
import static org.apache.commons.lang3.Validate.notBlank;
import static org.springframework.util.Assert.notNull;

/**
 * A single translation for an old norse word. The translation can be in any language
 * that has a (2 characters) language code.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Translation {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Integer id;

    private String languageCode;
    private String text;

    public Translation(String languageCode, String text) {
        notNull(languageCode, "languageCode should not be null");
        length(languageCode, 2, "languageCode should be exactly 2 chars long");
        notNull(text, "text should not be null");
        notBlank(text, "text should not be blank");

        this.languageCode = languageCode;
        this.text = text;
    }

    @ManyToMany
    @JoinTable(
            name = "word_translation",
            joinColumns = {@JoinColumn(name = "translation_id")},
            inverseJoinColumns = {@JoinColumn(name = "word_id")}
    )
    private List<Word> words;

    public boolean addWord(Word word){
        if (CollectionUtils.isEmpty(words)){
            words = new ArrayList<>();
        }
        if (words.contains(word)){
            return false;
        }
        return words.add(word);
    }
}
