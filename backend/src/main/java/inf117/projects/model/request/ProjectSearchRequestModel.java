package inf117.projects.model.request;

public class ProjectSearchRequestModel {
    private String name;
    private Integer teamSize;
    private String sponsor;
    private Integer year;
    private String term;
    private String courseDepartment;
    private String courseNumber;
    private Integer limit;
    private Integer page;
    private String orderBy;
    private String direction;

    public String getName() {
        return name;
    }

    public ProjectSearchRequestModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public ProjectSearchRequestModel setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
        return this;
    }

    public String getSponsor() {
        return sponsor;
    }

    public ProjectSearchRequestModel setSponsor(String sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public ProjectSearchRequestModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public ProjectSearchRequestModel setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public ProjectSearchRequestModel setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
        return this;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public ProjectSearchRequestModel setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public ProjectSearchRequestModel setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public ProjectSearchRequestModel setPage(Integer page) {
        this.page = page;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public ProjectSearchRequestModel setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public ProjectSearchRequestModel setDirection(String direction) {
        this.direction = direction;
        return this;
    }
}
