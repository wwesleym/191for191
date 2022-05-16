package inf117.projects.rest;

import com.codingsprojects.stack.core.result.Result;
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

@RestController
public class ProjectsController {
    private final ProjectRepo repo;

    @Autowired
    public ProjectsController(ProjectRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/sample/search")
    ProjectNameSearchResponseModel ProjectSearchByName(
            @RequestParam String name)
    {
        Project project = this.repo.projectByProjectName(name);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(Result.NO_RESULT);

        return response;
    }

    @PostMapping("/sample/projectById")
    ProjectNameSearchResponseModel ProjectSearchById(
            @RequestParam Integer Id)
    {
        Project project = this.repo.selectProjectId(Id);
        ProjectNameSearchResponseModel response = new ProjectNameSearchResponseModel();
        response.setProject(project);
        response.setResult(Result.NO_RESULT);

        return response;
    }

    @PostMapping("/sample/sponsor")
    SponsorSearchResponseModel SponsorSearchByName(
            @RequestParam String name)
    {
        Sponsor sponsor = this.repo.selectSponsor(name);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(Result.NO_RESULT);

        return response;
    }

    @PostMapping("/sample/sponsorId")
    SponsorSearchResponseModel SponsorSearchById(
            @RequestParam Integer Id)
    {
        Sponsor sponsor = this.repo.selectSponsorId(Id);
        SponsorSearchResponseModel response = new SponsorSearchResponseModel();
        response.setSponsor(sponsor);
        response.setResult(Result.NO_RESULT);

        return response;
    }
}
