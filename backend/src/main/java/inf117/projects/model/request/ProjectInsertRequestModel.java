package inf117.projects.model.request;

public class ProjectInsertRequestModel {
    private String name;
    private Integer teamSize;
    private String sponsorName;
    private String description;
    private String video;
    private String image;
    private String state;
    private String courseDepartment;
    private String courseNumber;
    private Integer year;
    private String term;

    public String getName() {
        return name;
    }

    public ProjectInsertRequestModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public ProjectInsertRequestModel setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
        return this;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public ProjectInsertRequestModel setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectInsertRequestModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public ProjectInsertRequestModel setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ProjectInsertRequestModel setImage(String image) {
        this.image = image;
        return this;
    }

    public String getState() {
        return state;
    }

    public ProjectInsertRequestModel setState(String state) {
        this.state = state;
        return this;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public ProjectInsertRequestModel setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
        return this;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public ProjectInsertRequestModel setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ProjectInsertRequestModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public ProjectInsertRequestModel setTerm(String term) {
        this.term = term;
        return this;
    }
}
