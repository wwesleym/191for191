package inf117.projects.repo.entity;

import inf117.projects.repo.entity.type.CourseTerm;

public class CourseInstance {
    private int id;
    private String department;
    private String number;
    private String professorName;
    private CourseTerm courseTerm;
    private int courseYear;

    public int getId() {
        return id;
    }

    public CourseInstance setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public CourseInstance setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public CourseInstance setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getProfessorName() {
        return professorName;
    }

    public CourseInstance setProfessorName(String professorName) {
        this.professorName = professorName;
        return this;
    }

    public CourseTerm getCourseTerm() {
        return courseTerm;
    }

    public CourseInstance setCourseTerm(CourseTerm courseTerm) {
        this.courseTerm = courseTerm;
        return this;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public CourseInstance setCourseYear(int courseYear) {
        this.courseYear = courseYear;
        return this;
    }
}
