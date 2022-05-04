package inf117.projects.model.response;

import inf117.projects.repo.entity.Project;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ProjectNameSearchResponseModel extends ResponseModel<ProjectNameSearchResponseModel> {

    Project project;

    public Project getProject() {
        return project;
    }

    public ProjectNameSearchResponseModel setProject(Project project) {
        this.project = project;
        return this;
    }
}
