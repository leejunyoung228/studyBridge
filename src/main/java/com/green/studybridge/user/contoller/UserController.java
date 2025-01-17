package com.green.studybridge.user.contoller;

import com.green.studybridge.config.model.ResultResponse;
import com.green.studybridge.user.model.UserUpdateReq;
import com.green.studybridge.user.service.UserService;
import com.green.studybridge.user.model.UserSignInReq;
import com.green.studybridge.user.model.UserSignInRes;
import com.green.studybridge.user.model.UserSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("sign-up")
    @Operation(description = "이메일 인증 링크를 누르게 되면 /user/complete-sign-up?token=토큰 값 으로 이동</br>" +
            "token 값을 /user/sign-up?token=토큰값 으로 보내주세요 ")
    public ResultResponse<Integer> signUp(@RequestBody UserSignUpReq req) {
        userService.sendEmail(req);
        return null;
    }

    @GetMapping("sign-up")
    public ResultResponse<UserSignInRes> finishSignUp(@RequestBody String token, HttpServletResponse response) {
        return ResultResponse.<UserSignInRes>builder().resultData(userService.signUp(token, response)).build();
    }

    @PostMapping("sign-in")
    public ResultResponse<UserSignInRes> signIn(/*@Valid*/ @RequestBody UserSignInReq req, HttpServletResponse response) {
        UserSignInRes res = userService.signIn(req, response);
        return ResultResponse.<UserSignInRes>builder()
                .resultData(res)
                .build();
    }

    @Operation(description = "<strong>type</strong> : email 또는 nick-name 중 택 일</br><strong>text</strong> : 검사할 문자")
    @GetMapping("check-duplicate/{type}")
    public ResultResponse<Integer> checkDuplicate(@RequestParam String text, @PathVariable String type) {
        int res = userService.checkDuplicate(text, type);
        return ResultResponse.<Integer>builder().resultData(res).build();
    }

    @PatchMapping
    public ResultResponse<Integer> updateUserPic(@RequestPart MultipartFile pic) {
        userService.updateUserPic(pic);
        return ResultResponse.<Integer>builder()
                .resultData(1)
                .build();
    }

    @PutMapping
    public ResultResponse<Integer> updateUser(/*@Valid*/ @RequestBody UserUpdateReq req) {
        userService.updateUser(req);
        return ResultResponse.<Integer>builder()
                .resultData(1)
                .build();
    }
}