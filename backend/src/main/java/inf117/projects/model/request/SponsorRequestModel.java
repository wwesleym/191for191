package inf117.projects.model.request;

public class SponsorRequestModel {
    String name;
    Integer Id;

    public String getName() {
        return name;
    }

    public SponsorRequestModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return Id;
    }

    public SponsorRequestModel setId(Integer id) {
        Id = id;
        return this;
    }
}
