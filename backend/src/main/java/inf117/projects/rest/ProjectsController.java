package inf117.projects.rest;

import inf117.projects.core.result.ProjectsResults;
import inf117.projects.model.request.ProjectModelRequest;
import inf117.projects.model.request.SponsorModelRequest;
import inf117.projects.model.response.SponsorSearchResponseModel;
import inf117.projects.repo.entity.Project;
import inf117.projects.model.response.ProjectNameSearchResponseModel;
import inf117.projects.repo.ProjectRepo;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectsController {
    private final ProjectRepo repo;

    @Autowired
    public ProjectsController(ProjectRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/projects/search/name/")
    ResponseEntity<ProjectNameSearchResponseModel> ProjectSearchByName(
            @RequestBody ProjectModelRequest request)
    {
        String name = request.getName();

        Project project = this.repo.projectByProjectName(name);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECTS_FOUND_WITHIN_SEARCH);

        return response.toResponse();
    }

    @PostMapping("/projects/search/id/")
    ResponseEntity<ProjectNameSearchResponseModel> ProjectSearchById(
            @RequestBody ProjectModelRequest request)
    {
        Integer id = request.getId();

        Project project = this.repo.selectProjectId(id);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECT_WITH_ID_FOUND);

        return response.toResponse();
    }

    @PostMapping("/sponsor/search/name/")
    ResponseEntity<SponsorSearchResponseModel> SponsorSearchByName(
            @RequestBody SponsorModelRequest request)
    {
        String name = request.getName();

        Sponsor sponsor = this.repo.selectSponsor(name);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSORS_FOUND_WITHIN_SEARCH);

        return response.toResponse();
    }

    @PostMapping("/sponsor/search/id/")
    ResponseEntity<SponsorSearchResponseModel> SponsorSearchById(
            @RequestBody SponsorModelRequest request)
    {
        Integer id = request.getId();

        Sponsor sponsor = this.repo.selectSponsorId(id);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSOR_WITH_ID_FOUND);

        return response.toResponse();
    }
}
