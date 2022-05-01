package inf117.projects.model.data;

import java.util.Locale;

public enum ProjectState {
    COMPLETED("COMPLETED"),
    IN_PROGRESS("IN_PROGRESS"),
    NOT_STARTED("NOT_STARTED");

    private String value;

    ProjectState(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static ProjectState fromString(String state) {
        if (state == null) {
            return COMPLETED;
        }

        switch (state.toUpperCase(Locale.ROOT).replace('_', ' ')) {
            case "IN PROGRESS":
                return IN_PROGRESS;
            case "NOT STARTED":
                return NOT_STARTED;
            default:
                // TODO: Create a custom exception for invalid project states.
                return null;
        }
    }
}
