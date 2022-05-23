package inf117.projects.repo;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;
import inf117.projects.model.request.ProjectSearchRequestModel;
import inf117.projects.repo.entity.CourseInstance;
import inf117.projects.repo.entity.Project;
import inf117.projects.repo.entity.type.CourseTerm;
import inf117.projects.repo.entity.type.ProjectState;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;

@Component
public class ProjectRepo {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public ProjectRepo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //language=sql
    private static String PROJECT_SEARCH_WITH_DEFAULT =
            "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id " +
            "FROM `191for191`.project p " +
            "JOIN `191for191`.sponsor s ON s.id = p.sponsor_id ";

    public List<Project> projectSearch(ProjectSearchRequestModel request) {
        return null;
    }

    public Project projectByProjectName(String name) {
        try {
            return this.template.queryForObject(
                    "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id, p.year, p.term " +
                            "FROM `191for191`.project p " +
                            "JOIN `191for191`.sponsor s ON s.id = p.sponsor_id " +
                            "WHERE p.name LIKE :name ",
                    new MapSqlParameterSource()
                            .addValue("name", '%' + name + '%', Types.VARCHAR),
                    (rs, rowNum) -> new Project()
                            .setId(rs.getLong("p.id"))
                            .setName(rs.getString("p.name"))
                            .setTeamSize(rs.getInt("p.team_size"))
                            .setSponsorName(rs.getString("s.name"))
                            .setDescription(rs.getString("p.project_description"))
                            .setVideo(rs.getString("p.pitch_video"))
                            .setImage(rs.getString("p.image"))
                            .setState(ProjectState.fromString(rs.getString("p.state")))
                            .setCourseId(rs.getInt("p.course_instance_id"))
                            .setYear(rs.getInt("p.year"))
                            .setTerm(CourseTerm.fromString(rs.getString("p.term")))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_PROJECTS_FOUND_WITHIN_SEARCH);
        }
    }

    public void insertProject(Project project) {
        // Check if sponsor name in database
        Sponsor sponsor;
            try {
                if (project.getSponsorName() != null) {
                    sponsor = this.selectSponsor(project.getSponsorName());
                } else {
                    sponsor = null;
                }
            } catch (DataAccessException e) {
                sponsor = null;
            }

        // Insert new sponsor if sponsor name not in database
        if (sponsor == null) {
            sponsor = new Sponsor()
                    .setId(project.getId())
                    .setName(project.getSponsorName());

            // Insert sponsor into database
            this.insertSponsor(sponsor);
        }

        // Insert project in database
        try {
            this.template.update(
                    "INSERT INTO `191for191`.project (id, name, team_size, sponsor_id, " +
                            "project_description, pitch_video, image, state, " +
                            "course_instance_id, year, term) " +
                            "VALUES (:id, :name, :teamSize, :sponsorId, " +
                            ":projectDescription, :pitchVideo, :image, :state, :courseId, :year, :term);",
                    new MapSqlParameterSource()
                            .addValue("id", project.getId(), Types.INTEGER)
                            .addValue("name", project.getName(), Types.VARCHAR)
                            .addValue("teamSize", project.getTeamSize(), Types.INTEGER)
                            .addValue("sponsorId", sponsor.getId(), Types.INTEGER)
                            .addValue("projectDescription", project.getDescription(), Types.VARCHAR)
                            .addValue("pitchVideo", project.getVideo(), Types.VARCHAR)
                            .addValue("image", project.getImage(), Types.VARCHAR)
                            .addValue("state", project.getState(), Types.VARCHAR)
                            .addValue("courseId", project.getCourseId(), Types.INTEGER)
                            .addValue("year", project.getYear(), Types.INTEGER)
                            .addValue("term", project.getTerm().toString(), Types.VARCHAR)
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.PROJECT_ALREADY_EXISTS);
        }

    }

    public Sponsor selectSponsor(String name) {
        try {
            return this.template.queryForObject(
                    "SELECT s.id, s.name, s.website " +
                            "FROM `191for191`.sponsor s " +
                            "WHERE s.name LIKE :name ",
                    new MapSqlParameterSource()
                            .addValue("name", '%'+name+'%', Types.VARCHAR),
                    (rs, rowNum) ->
                            new Sponsor()
                                    .setId(rs.getLong("s.id"))
                                    .setName(rs.getString("s.name"))
                                    .setWebsite(rs.getString("s.website"))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_SPONSORS_FOUND_WITHIN_SEARCH);
        }
    }

    public void insertSponsor(Sponsor sponsor) {
        this.template.update(
                "INSERT INTO `191for191`.sponsor (id, name) " +
                        "VALUES (:id, :name);",
                new MapSqlParameterSource()
                        .addValue("id", sponsor.getId(), Types.INTEGER)
                        .addValue("name", sponsor.getName(), Types.VARCHAR)
        );
    }

    public Project selectProjectId(Integer id)
    {
        try {
            return this.template.queryForObject(
                    "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id, p.year, p.term " +
                            "FROM `191for191`.project p " +
                            "JOIN `191for191`.sponsor s ON s.id = p.sponsor_id " +
                            "WHERE p.id = :id ",
                    new MapSqlParameterSource()
                            .addValue("id", id, Types.INTEGER),
                    (rs, rowNum) -> new Project()
                            .setId(rs.getLong("p.id"))
                            .setName(rs.getString("p.name"))
                            .setTeamSize(rs.getInt("p.team_size"))
                            .setSponsorName(rs.getString("s.name"))
                            .setDescription(rs.getString("p.project_description"))
                            .setVideo(rs.getString("p.pitch_video"))
                            .setImage(rs.getString("p.image"))
                            .setState(ProjectState.fromString(rs.getString("p.state")))
                            .setCourseId(rs.getInt("p.course_instance_id"))
                            .setYear(rs.getInt("p.year"))
                            .setTerm(CourseTerm.fromString(rs.getString("p.term")))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_PROJECT_WITH_ID_FOUND);
        }
    }

    public Sponsor selectSponsorId(Integer id)
    {
        try {
            return this.template.queryForObject(
                    "SELECT s.id, s.name, s.website " +
                            "FROM `191for191`.sponsor s " +
                            "WHERE s.id=:id ",
                    new MapSqlParameterSource()
                            .addValue("id", id, Types.INTEGER),
                    (rs, rowNum) ->
                            new Sponsor()
                                    .setId(rs.getLong("s.id"))
                                    .setName(rs.getString("s.name"))
                                    .setWebsite(rs.getString("s.website"))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_SPONSOR_WITH_ID_FOUND);
        }
    }

    public CourseInstance selectCourseInstance(CourseInstance courseInstance) {
        try {
            return this.template.queryForObject(
                    "SELECT ci.id, ci.year, ci.term, ci.department, ci.number, p.name_first, p.name_first, p.name_middle, p.name_last " +
                            "FROM `191for191`.course_instance ci " +
                            "JOIN `191for191`.person p ON p.id = ci.professor_id " +
                            "WHERE ci.id=:id AND ci.year=:year AND ci.term=:term;",
                    new MapSqlParameterSource()
                            .addValue("id", courseInstance.getId(), Types.INTEGER)
                            .addValue("year", courseInstance.getCourseYear(), Types.INTEGER)
                            .addValue("term", courseInstance.getCourseTerm().toString(), Types.VARCHAR),
                    (rs, rowNum) -> {
                        String professorName = rs.getString("p.name_first") +
                                " " + rs.getString("p.name_middle") +
                                " " + rs.getString("p.name_last");
                        professorName = professorName.replace("\\s\\s+", " ");

                        CourseInstance course = new CourseInstance()
                                .setId(rs.getInt("ci.id"))
                                .setDepartment(rs.getString("ci.department"))
                                .setNumber(rs.getString("ci.number"))
                                .setCourseYear(rs.getInt("ci.year"))
                                .setCourseTerm(CourseTerm.fromString(rs.getString("ci.term")));

                        return course.setProfessorName(professorName);
                    }
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.COURSE_NOT_FOUND);
        }
    }
}
