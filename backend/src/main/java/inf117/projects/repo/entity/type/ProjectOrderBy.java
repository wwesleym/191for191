package inf117.projects.repo.entity.type;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;

import java.util.Locale;

public enum ProjectOrderBy {
    NAME(" ORDER BY p.name "),
    TEAM_SIZE(" ORDER BY p.team_size "),
    YEAR(" ORDER BY p.year ");

    private final String sql;

    ProjectOrderBy(String sql) {
        this.sql = sql;
    }

    public String toSql() {
        return this.sql;
    }

    public static ProjectOrderBy fromString(String orderBy) {
        if (orderBy == null) {
            return NAME;
        }

        switch (orderBy.toUpperCase(Locale.ROOT).replace('_', ' ')) {
            case "NAME":
                return NAME;
            case "TEAM SIZE":
                return TEAM_SIZE;
            case "YEAR":
                return YEAR;
            default:
                throw new ResultError(ProjectsResults.INVALID_ORDER_BY);
        }
    }
}
