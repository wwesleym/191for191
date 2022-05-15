package inf117.projects.core.base;

import com.github.klefstad_teaching.cs122b.core.result.Result;
import org.springframework.http.ResponseEntity;

public final class ResultResponse extends ResponseModel<ResultResponse>
{
    private ResultResponse(Result result)
    {
        setResult(result);
    }

    public static ResultResponse of(Result result)
    {
        return new ResultResponse(result);
    }

    public static ResponseEntity<ResultResponse> response(Result result)
    {
        return new ResultResponse(result).toResponse();
    }
}