package inf117.projects.model.request;

public class SponsorModelRequest {
    String name;
    Integer id;

    public String getName() {
        return name;
    }

    public SponsorModelRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public SponsorModelRequest setId(Integer id) {
        this.id = id;
        return this;
    }
}
