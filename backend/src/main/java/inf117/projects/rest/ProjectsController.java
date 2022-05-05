package inf117.projects.rest;

import inf117.projects.model.response.SponsorSearchResponseModel;
import inf117.projects.repo.entity.Project;
import inf117.projects.model.response.ProjectNameSearchResponseModel;
import inf117.projects.repo.ProjectRepo;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {
    private final ProjectRepo repo;

    @Autowired
    public ProjectsController(ProjectRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/sample/search")
    ProjectNameSearchResponseModel ProjectSearchByName(
            @RequestParam String name)
    {
        Project project = this.repo.projectByProjectName(name);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel()
                .setProject(project);

        return response;
    }

    @GetMapping("/sample/projectById")
    ProjectNameSearchResponseModel ProjectSearchById(
            @RequestParam Integer Id)
    {
        Project project = this.repo.projectByProjectId(Id);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel()
                .setProject(project);

        return response;
    }

    @GetMapping("/sample/sponsor")
    SponsorSearchResponseModel SponsorSearchByName(
            @RequestParam String name)
    {
        Sponsor sponsor = this.repo.sponsorBySponsorName(name);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel()
                .setSponsor(sponsor);

        return response;
    }

    @GetMapping("/sample/sponsorId")
    SponsorSearchResponseModel SponsorSearchById(
            @RequestParam Integer Id)
    {
        Sponsor sponsor = this.repo.sponsorBySponsorId(Id);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel()
                .setSponsor(sponsor);

        return response;
    }
}
