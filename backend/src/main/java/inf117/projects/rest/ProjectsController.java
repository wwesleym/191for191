package inf117.projects.rest;

import inf117.projects.core.result.ProjectsResults;
import inf117.projects.model.response.SponsorSearchResponseModel;
import inf117.projects.repo.entity.Project;
import inf117.projects.model.response.ProjectNameSearchResponseModel;
import inf117.projects.repo.ProjectRepo;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import inf117.projects.util.validate;

@RestController
public class ProjectsController {
    private final ProjectRepo repo;

    @Autowired
    public ProjectsController(ProjectRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/projects/search/name/")
    ProjectNameSearchResponseModel ProjectSearchByName(
            @RequestParam String name)
    {
        Project project = this.repo.projectByProjectName(name);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECTS_FOUND_WITHIN_SEARCH);

        return response;
    }

    @GetMapping("/projects/search/id/")
    ProjectNameSearchResponseModel ProjectSearchById(
            @RequestParam Integer Id)
    {
        Project project = this.repo.selectProjectId(Id);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(ProjectsResults.PROJECT_WITH_ID_FOUND);

        return response;
    }

    @GetMapping("/sponsor/search/name/")
    SponsorSearchResponseModel SponsorSearchByName(
            @RequestParam String name)
    {
        Sponsor sponsor = this.repo.selectSponsor(name);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSORS_FOUND_WITHIN_SEARCH);

        return response;
    }

    @GetMapping("/sponsor/search/id/")
    SponsorSearchResponseModel SponsorSearchById(
            @RequestParam Integer Id)
    {
        Sponsor sponsor = this.repo.selectSponsorId(Id);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(ProjectsResults.SPONSOR_WITH_ID_FOUND);

        return response;
    }
}
