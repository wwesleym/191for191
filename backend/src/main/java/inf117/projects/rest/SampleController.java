package inf117.projects.rest;

import inf117.projects.model.data.Project;
import inf117.projects.model.response.SampleProjectByNameResponseModel;
import inf117.projects.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private final ProjectRepo repo;

    @Autowired
    public SampleController(ProjectRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/sample/search")
    ResponseEntity sampleProjectByProjectName(
            @RequestParam String name
    ) {
        Project project = this.repo.projectByProjectName(name);

        SampleProjectByNameResponseModel response = new SampleProjectByNameResponseModel()
                .setProject(project);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
