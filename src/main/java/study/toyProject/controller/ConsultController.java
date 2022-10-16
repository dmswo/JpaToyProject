package study.toyProject.controller;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.toyProject.common.ApiResultInfo;
import study.toyProject.common.ResultCodeStatus;
import study.toyProject.dto.requestDto.ConsultListRequestDto;
import study.toyProject.service.ConsultService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consult")
public class ConsultController {

    private final ConsultService consultService;

    @GetMapping("/list")
    public ResponseEntity<?> consultList(@RequestBody ConsultListRequestDto consultListRequestDto, Pageable pageable) {
        ApiResultInfo apiResultInfo = new ApiResultInfo();
        JSONObject jsonObject = apiResultInfo.getResultJson();

        try {
            Page list = consultService.getConsultList(consultListRequestDto, pageable);
            jsonObject.put("consultList", list);
        } catch (Exception e) {
            apiResultInfo.setErrorMsg(e.getMessage());
            apiResultInfo.setResultCode(ResultCodeStatus.SERVER_ERROR);
        }

        jsonObject.put("resultCode", apiResultInfo.getResultCode().value());
        jsonObject.put("resultMsg", apiResultInfo.getResultCode().reasonPhrase());

        return new ResponseEntity<JSONObject>(apiResultInfo.getResultJson(), apiResultInfo.getHttpStatus());
    }


}
