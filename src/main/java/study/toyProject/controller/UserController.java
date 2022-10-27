package study.toyProject.controller;

import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.toyProject.common.ApiResultInfo;
import study.toyProject.common.ResultCodeStatus;
import study.toyProject.dto.user.requestDto.UserJoinRequestDto;
import study.toyProject.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> userSave(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        ApiResultInfo apiResultInfo = new ApiResultInfo();
        JSONObject jsonObject = apiResultInfo.getResultJson();

        try {
            userService.userSave(userJoinRequestDto);
        } catch (Exception e) {
            apiResultInfo.setErrorMsg(e.getMessage());
            apiResultInfo.setResultCode(ResultCodeStatus.SERVER_ERROR);
        }

        jsonObject.put("resultCode", apiResultInfo.getResultCode().value());
        jsonObject.put("resultMsg", apiResultInfo.getResultCode().reasonPhrase());

        return new ResponseEntity<JSONObject>(apiResultInfo.getResultJson(), apiResultInfo.getHttpStatus());
    }
}
