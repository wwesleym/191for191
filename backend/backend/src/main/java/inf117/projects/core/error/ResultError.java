package inf117.projects.core.error;

import com.github.klefstad_teaching.cs122b.core.result.Result;
import inf117.projects.core.base.ResultResponse;;

public final class ResultError extends RuntimeException
{
    private final ResultResponse body;

    public ResultError(Result result)
    {
        this.body = ResultResponse.of(result);
    }

    public ResultResponse getBody()
    {
        return body;
    }
}
