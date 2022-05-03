package inf117.projects.model.response;

import inf117.projects.model.data.Project;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SampleProjectByNameResponseModel {
    private Project project;

    public Project getProject() {
        return project;
    }

    public SampleProjectByNameResponseModel setProject(Project project) {
        this.project = project;
        return this;
    }
}
