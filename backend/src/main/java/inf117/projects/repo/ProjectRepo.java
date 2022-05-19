package inf117.projects.repo;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;
import inf117.projects.repo.entity.Project;
import inf117.projects.repo.entity.type.ProjectState;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;

@Component
public class ProjectRepo {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public ProjectRepo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //language=sql
    private static String PROJECT_WITH_DEFAULT =
            "";

    public Project projectByProjectName(String name) {
        try {
            return this.template.queryForObject(
                    "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id " +
                            "FROM `191for191`.project p " +
                            "JOIN `191for191`.sponsor s ON s.id = p.sponsor_id " +
                            "WHERE p.name LIKE :name ",
                    new MapSqlParameterSource()
                            .addValue("name", '%' + name + '%', Types.VARCHAR),
                    (rs, rowNum) -> new Project()
                            .setId(rs.getInt("p.id"))
                            .setName(rs.getString("p.name"))
                            .setTeamSize(rs.getInt("p.team_size"))
                            .setSponsorName(rs.getString("s.name"))
                            .setDescription(rs.getString("p.project_description"))
                            .setVideo(rs.getString("p.pitch_video"))
                            .setImage(rs.getString("p.image"))
                            .setState(ProjectState.fromString(rs.getString("p.state")))
                            .setCourseId(rs.getInt("p.course_instance_id"))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_PROJECTS_FOUND_WITHIN_SEARCH);
        }
    }

    public void insertProject(Project project) {
        // Check if sponsor name in database
        Sponsor sponsor;
        if (project.getSponsorName() != null) {
            sponsor = selectSponsor(project.getSponsorName());
        } else {
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
        this.template.update(
                "INSERT INTO `191for191`.project (id, name, team_size, sponsor_id, " +
                        "project_description, pitch_video, image, state, course_instance_id) " +
                        "VALUES (:id, :name, :teamSize, :sponsorId, " +
                        ":projectDescription, :pitchVideo, :image, :state, :courseId);",
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
        );

    }

    public Sponsor selectSponsor(String name) {
        try {
            return this.template.queryForObject(
                    "SELECT s.id, s.name " +
                            "FROM `191for191`.sponsor s " +
                            "WHERE s.name LIKE :name ",
                    new MapSqlParameterSource()
                            .addValue("name", '%'+name+'%', Types.VARCHAR),
                    (rs, rowNum) ->
                            new Sponsor()
                                    .setId(rs.getInt("s.id"))
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
                    "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id " +
                            "FROM `191for191`.project p " +
                            "JOIN `191for191`.sponsor s ON s.id = p.sponsor_id " +
                            "WHERE p.id = :id ",
                    new MapSqlParameterSource()
                            .addValue("id", id, Types.INTEGER),
                    (rs, rowNum) -> new Project()
                            .setId(rs.getInt("p.id"))
                            .setName(rs.getString("p.name"))
                            .setTeamSize(rs.getInt("p.team_size"))
                            .setSponsorName(rs.getString("s.name"))
                            .setDescription(rs.getString("p.project_description"))
                            .setVideo(rs.getString("p.pitch_video"))
                            .setImage(rs.getString("p.image"))
                            .setState(ProjectState.fromString(rs.getString("p.state")))
                            .setCourseId(rs.getInt("p.course_instance_id"))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_PROJECT_WITH_ID_FOUND);
        }
    }

    public Sponsor selectSponsorId(Integer id)
    {
        try {
            return this.template.queryForObject(
                    "SELECT s.id, s.name " +
                            "FROM `191for191`.sponsor s " +
                            "WHERE s.id=:id ",
                    new MapSqlParameterSource()
                            .addValue("id", id, Types.INTEGER),
                    (rs, rowNum) ->
                            new Sponsor()
                                    .setId(rs.getInt("s.id"))
                                    .setName(rs.getString("s.name"))
                                    .setWebsite(rs.getString("s.website"))
            );
        } catch (DataAccessException e) {
            throw new ResultError(ProjectsResults.NO_SPONSOR_WITH_ID_FOUND);
        }
    }
}
