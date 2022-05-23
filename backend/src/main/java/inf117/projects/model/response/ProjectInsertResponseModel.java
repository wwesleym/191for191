package inf117.projects.model.response;

import inf117.projects.core.base.ResponseModel;
import inf117.projects.repo.entity.Project;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ProjectInsertResponseModel extends ResponseModel<ProjectInsertResponseModel> {

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
