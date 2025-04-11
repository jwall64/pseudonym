package dev.jwall64.pseudonym.lang;

public interface LocaleHolder {

    String getLanguage();

    static LocaleHolder direct(String language) {
        return new Direct(language);
    }

    record Direct(String language) implements LocaleHolder {
        @Override
        public String getLanguage() {
            return language;
        }
    }

}
