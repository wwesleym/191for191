package inf117.projects.repo.entity;

public class Sponsor {
    private int id;
    private String name;
    private String website;

    public int getId() {
        return id;
    }

    public Sponsor setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sponsor setName(String name) {
        this.name = name;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Sponsor setWebsite(String website) {
        this.website = website;
        return this;
    }
}
