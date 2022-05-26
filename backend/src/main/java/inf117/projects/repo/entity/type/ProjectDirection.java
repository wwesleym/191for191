package inf117.projects.repo.entity.type;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;

import java.util.Locale;

public enum ProjectDirection {
    ASC(" ASC, p.id "),
    DESC(" DESC, p.id ");

    private final String sql;

    ProjectDirection(String sql) {
        this.sql = sql;
    }

    public String toSql() {
        return this.sql;
    }

    public static ProjectDirection fromString(String direction) {
        if (direction == null) {
            return ASC;
        }

        switch (direction.toUpperCase(Locale.ROOT)) {
            case "ASC":
                return ASC;
            case "DESC":
                return DESC;
            default:
                throw new ResultError(ProjectsResults.INVALID_DIRECTION);
        }
    }
}
