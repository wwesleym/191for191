package inf117.projects.repo.entity;

import inf117.projects.repo.entity.type.CourseTerm;
import inf117.projects.repo.entity.type.ProjectState;

public class Project {
    private Long id;
    private String name;
    private Integer teamSize;
    private String sponsorName;
    private String description;
    private String video;
    private String image;
    private ProjectState state;
    private Integer courseId;
    private Integer year;
    private CourseTerm term;

    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public Project setTeamSize(int teamSize) {
        this.teamSize = teamSize;
        return this;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public Project setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public Project setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Project setImage(String image) {
        this.image = image;
        return this;
    }

    public ProjectState getState() {
        return state;
    }

    public Project setState(ProjectState state) {
        this.state = state;
        return this;
    }

    public int getCourseId() {
        return courseId;
    }

    public Project setCourseId(int courseId) {
        this.courseId = courseId;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Project setYear(int year) {
        this.year = year;
        return this;
    }

    public CourseTerm getTerm() {
        return term;
    }

    public Project setTerm(CourseTerm term) {
        this.term = term;
        return this;
    }
}
