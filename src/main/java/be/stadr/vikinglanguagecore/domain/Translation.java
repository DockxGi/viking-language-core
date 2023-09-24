package be.stadr.vikinglanguagecore.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

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
