package inf117.projects.model.request;

public class ProjectRequestModel {
    String name;
    Integer Id;

    public String getName() {
        return name;
    }

    public ProjectRequestModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return Id;
    }

    public ProjectRequestModel setId(Integer id) {
        Id = id;
        return this;
    }
}
