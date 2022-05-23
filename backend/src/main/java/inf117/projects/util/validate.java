package inf117.projects.util;

import inf117.projects.core.error.ResultError;
import inf117.projects.core.result.ProjectsResults;
import inf117.projects.repo.entity.CourseInstance;
import org.springframework.stereotype.Component;

@Component
public final class Validate {

    public void validateSearchProjectName(String name){return;}
    public void validateSearchProjectId(Integer Id){return;}
    public void validateSearchSponsorName(String name){return;}
    public void validateSearchSponsorId(Integer Id){return;}
    public void validateCourseInstance(CourseInstance courseInstance) {
        if ((courseInstance.getDepartment() == null) ||
                (courseInstance.getNumber() == null) ||
                (courseInstance.getCourseTerm() == null) ||
                (courseInstance.getCourseYear() == 0)) {
            throw new ResultError(ProjectsResults.COURSE_NOT_FOUND);
        }
    }
}
