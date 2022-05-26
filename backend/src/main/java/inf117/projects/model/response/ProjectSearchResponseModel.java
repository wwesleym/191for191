package inf117.projects.model.response;

import inf117.projects.core.base.ResponseModel;
import inf117.projects.repo.entity.Project;

import java.util.List;

public class ProjectSearchResponseModel extends ResponseModel<ProjectSearchResponseModel> {
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public ProjectSearchResponseModel setProjects(List<Project> projects) {
        this.projects = projects;
        return this;
    }
}
