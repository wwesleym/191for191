package inf117.projects.rest;

import inf117.projects.core.result.ProjectsResults;
import inf117.projects.model.request.ProjectInsertRequestModel;
import inf117.projects.model.request.ProjectModelRequest;
import inf117.projects.model.request.SponsorModelRequest;
import inf117.projects.model.response.ProjectInsertResponseModel;
import inf117.projects.model.response.SponsorSearchResponseModel;
import inf117.projects.repo.entity.CourseInstance;
import inf117.projects.repo.entity.Project;
import inf117.projects.model.response.ProjectNameSearchResponseModel;
import inf117.projects.repo.ProjectRepo;
import inf117.projects.repo.entity.Sponsor;
import inf117.projects.repo.entity.type.CourseTerm;
import inf117.projects.repo.entity.type.ProjectState;
import inf117.projects.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class ProjectsController {
    private final ProjectRepo repo;
    private final Validate validate;

    @Autowired
    public ProjectsController(ProjectRepo repo, Validate validate) {
        this.repo = repo;
        this.validate = validate;
    }

    @GetMapping("/projects/search/name")
    ResponseEntity<ProjectNameSearchResponseModel> ProjectSearchByName(
            @RequestParam String name)
    {
        Project project = this.repo.projectByProjectName(name);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECTS_FOUND_WITHIN_SEARCH);

        return response.toResponse();
    }

    @GetMapping("/projects/search/id")
    ResponseEntity<ProjectNameSearchResponseModel> ProjectSearchById(
            @RequestParam Integer id)
    {
        Project project = this.repo.selectProjectId(id);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECT_WITH_ID_FOUND);

        return response.toResponse();
    }

    @PostMapping("/projects/insert")
    ResponseEntity<ProjectInsertResponseModel> insertProject(
            @RequestBody ProjectInsertRequestModel request
    ) {
        // Validate course instance
        CourseInstance courseInstance = new CourseInstance()
                .setId(request.getCourseId())
                .setCourseTerm(CourseTerm.fromString(request.getTerm()))
                .setCourseYear(request.getYear());
        this.validate.validateCourseInstance(courseInstance);
        courseInstance = this.repo.selectCourseInstance(courseInstance);

        // Create Project object

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yymmddhhmmss");
        Long projectId = Long.valueOf(dateFormat.format(date));

        Project project = new Project()
                .setId(projectId)
                .setName(request.getName())
                .setTeamSize(request.getTeamSize())
                .setSponsorName(request.getSponsorName())
                .setDescription(request.getDescription())
                .setVideo(request.getVideo())
                .setImage(request.getImage())
                .setState(ProjectState.fromString(request.getState()))
                .setCourseId(request.getCourseId())
                .setYear(request.getYear())
                .setTerm(CourseTerm.fromString(request.getTerm()));

        // Insert project into database
        this.repo.insertProject(project);

        // Return response
        ProjectInsertResponseModel response = new ProjectInsertResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECT_REGISTERED_SUCCESSFULLY);

        return response.toResponse();
    }

    @GetMapping("/sponsor/search/name")
    ResponseEntity<SponsorSearchResponseModel> SponsorSearchByName(
            @RequestParam String name)
    {
        Sponsor sponsor = this.repo.selectSponsor(name);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSORS_FOUND_WITHIN_SEARCH);

        return response.toResponse();
    }

    @GetMapping("/sponsor/search/id")
    ResponseEntity<SponsorSearchResponseModel> SponsorSearchById(
            @RequestParam Integer id)
    {
        Sponsor sponsor = this.repo.selectSponsorId(id);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSOR_WITH_ID_FOUND);

        return response.toResponse();
    }
}
