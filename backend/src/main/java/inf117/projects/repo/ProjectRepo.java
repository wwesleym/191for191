package inf117.projects.repo;

import inf117.projects.model.data.Project;
import inf117.projects.model.data.ProjectState;
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
    }
}
