package study.toyProject.common;

import lombok.Data;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;

@Data
public class ApiResultInfo {
    private ResultCodeStatus resultCode;
    private JSONObject resultJson;
    private HttpStatus httpStatus;
    private String errorMsg;

    public ApiResultInfo(){
        this.resultCode = ResultCodeStatus.OK;
        this.httpStatus = HttpStatus.OK;
        this.resultJson = new JSONObject();
    }
}
