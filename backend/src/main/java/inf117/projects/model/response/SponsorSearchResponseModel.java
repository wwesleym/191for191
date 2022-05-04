package inf117.projects.model.response;

import inf117.projects.repo.entity.Project;
import inf117.projects.repo.entity.Sponsor;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SponsorSearchResponseModel extends ResponseModel<SponsorSearchResponseModel> {

    Sponsor sponsor;

    public Sponsor getSponsor() {
        return sponsor;
    }
    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }
}
