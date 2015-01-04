package org.mdo.tools.game.teso.alchemy.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author MDO
 * @since 31/12/2014
 */
@Entity
@Table(name = "TRANSLATION")
public class TranslationEntity {
    @EmbeddedId
    private TranslationId id;
    @Column(name = "VALUE")
    private String value;

    public static class TranslationId implements Serializable {
        @Column(name = "LOCALE")
        private String locale;
        @Column(name = "REF")
        private String ref;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }
    }

    public TranslationId getId() {
        return id;
    }

    public void setId(TranslationId id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
