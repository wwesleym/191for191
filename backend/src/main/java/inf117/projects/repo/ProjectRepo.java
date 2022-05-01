package inf117.projects.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProjectRepo {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public ProjectRepo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
}
