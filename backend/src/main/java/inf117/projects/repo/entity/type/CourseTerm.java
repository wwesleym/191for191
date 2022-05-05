package inf117.projects.repo.entity.type;

import java.util.Locale;

public enum CourseTerm {
    WINTER("WINTER"),
    SPRING("SPRING"),
    SUMMER("SUMMER"),
    FALL("FALL");

    private String value;

    CourseTerm(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static CourseTerm fromString(String term) {
        if (term == null) {
            return WINTER;
        }

        switch (term.toUpperCase(Locale.ROOT)) {
            case "WINTER":
                return WINTER;
            case "SPRING":
                return SPRING;
            case "SUMMER":
                return SUMMER;
            case "FALL":
                return FALL;
            default:
                // TODO: Create a custom exception for invalid course terms.
                return null;
        }
    }
}
