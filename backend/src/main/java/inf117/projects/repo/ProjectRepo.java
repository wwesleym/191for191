package inf117.projects.repo;

import inf117.projects.model.data.Project;
import inf117.projects.model.data.ProjectState;
import inf117.projects.model.data.Sponsor;
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
    private static String PROJECT_WITH_DEFAULT =
            "";

    public Project projectByProjectName(String name) {
        return this.template.queryForObject(
                "SELECT p.id, p.name, p.team_size, s.name, p.project_description, p.pitch_video, p.image, p.state, p.course_instance_id " +
                    "FROM projects.project p " +
                        "JOIN projects.sponsor s on s.id = p.sponsor_id " +
                    "WHERE p.name LIKE :name ",
                new MapSqlParameterSource()
                        .addValue("name", '%'+name+'%', Types.VARCHAR),
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
                "INSERT INTO projects.project (id, name, team_size, sponsor_id, " +
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
                            "FROM projects.sponsor s " +
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
            return null;
        }
    }

    public void insertSponsor(Sponsor sponsor) {
        this.template.update(
                "INSERT INTO projects.sponsor (id, name) " +
                    "VALUES (:id, :name);",
                new MapSqlParameterSource()
                        .addValue("id", sponsor.getId(), Types.INTEGER)
                        .addValue("name", sponsor.getName(), Types.VARCHAR)
        );
    }
}
