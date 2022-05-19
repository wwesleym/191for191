package inf117.projects.core.result;

import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

public final class ProjectsResults {
    private ProjectsResults() {
        throw new AssertionError("No Instances of Results can be created");
    }

    public static final Result PROJECT_WITH_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2010)
                    .message("Movie found with the specified ID")
                    .build();

    public static final Result NO_PROJECT_WITH_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2011)
                    .message("No Movie found for the specified ID")
                    .build();

    public static final Result PROJECTS_FOUND_WITHIN_SEARCH =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2020)
                    .message("Movies with the given search parameters found")
                    .build();

    public static final Result NO_PROJECTS_FOUND_WITHIN_SEARCH =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2021)
                    .message("No movies found with the given search parameters")
                    .build();

    public static final Result PROJECTS_WITH_SPONSOR_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2030)
                    .message("Movies found with the personId")
                    .build();

    public static final Result NO_PROJECTS_WITH_SPONSOR_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2031)
                    .message("No Movies found with the personId")
                    .build();

    public static final Result SPONSOR_WITH_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2040)
                    .message("Person found with the specified ID")
                    .build();

    public static final Result NO_SPONSOR_WITH_ID_FOUND =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2041)
                    .message("No Person found for the specified ID")
                    .build();

    public static final Result SPONSORS_FOUND_WITHIN_SEARCH =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2050)
                    .message("Persons with the given search parameters found")
                    .build();

    public static final Result NO_SPONSORS_FOUND_WITHIN_SEARCH =
            new Result.Builder()
                    .status(HttpStatus.OK)
                    .code(2051)
                    .message("No Persons found with the given search parameters")
                    .build();

    static Stream<Result> toStream() {
        return Stream.of(
                PROJECT_WITH_ID_FOUND,
                NO_PROJECT_WITH_ID_FOUND,
                PROJECTS_FOUND_WITHIN_SEARCH,
                NO_PROJECTS_FOUND_WITHIN_SEARCH,
                NO_PROJECTS_WITH_SPONSOR_ID_FOUND,
                PROJECTS_WITH_SPONSOR_ID_FOUND,
                SPONSOR_WITH_ID_FOUND,
                NO_SPONSOR_WITH_ID_FOUND,
                SPONSORS_FOUND_WITHIN_SEARCH,
                NO_SPONSORS_FOUND_WITHIN_SEARCH
        );
    }
}
