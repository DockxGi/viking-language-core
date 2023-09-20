package be.stadr.vikinglanguagecore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * A single translation for an old norse word. The translation can be in any language
 * that has a (2 characters) language code.
 */
@Getter
@Setter
@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Integer id;

    private String languageCode;
    private String text;

    @ManyToMany
    @JoinTable(
            name = "word_translation",
            joinColumns = {@JoinColumn(name = "translation_id")},
            inverseJoinColumns = {@JoinColumn(name = "word_id")}
    )
    private List<Word> words;
}
