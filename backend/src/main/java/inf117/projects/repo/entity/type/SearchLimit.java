package inf117.projects.repo.entity.type;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;

public enum SearchLimit {
    TEN(" LIMIT 10 "),
    TWENTY_FIVE(" LIMIT 25 "),
    FIFTY(" LIMIT 50 "),
    HUNDRED(" LIMIT 100 ");

    private String sql;

    SearchLimit(String sql) {
        this.sql = sql;
    }

    public String toSql() {
        return this.sql;
    }

    public static SearchLimit fromInt(Integer limit) {
        if (limit == null) {
            return TEN;
        }

        switch (limit) {
            case 10:
                return TEN;
            case 25:
                return TWENTY_FIVE;
            case 50:
                return FIFTY;
            case 100:
                return HUNDRED;
            default:
                throw new ResultError(ProjectsResults.INVALID_LIMIT);
        }
    }
}
