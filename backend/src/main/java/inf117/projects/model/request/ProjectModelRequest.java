package inf117.projects.model.request;

import inf117.projects.repo.entity.Project;

public class ProjectModelRequest {
    String name;
    Integer id;

    public String getName() {
        return name;
    }

    public ProjectModelRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public ProjectModelRequest setId(Integer id) {
        this.id = id;
        return this;
    }
}
