package inf117.projects.model.data;

public class Project {
    private int projectId;
    private String name;
    private int teamSize;
    private String sponsorName;
    private String description;
    private String video;
    private String image;
    private ProjectState state;
    private int courseId;

    public int getProjectId() {
        return projectId;
    }

    public Project setProjectId(int projectId) {
        this.projectId = projectId;
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
}
