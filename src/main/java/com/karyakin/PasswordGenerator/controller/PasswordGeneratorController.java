package com.karyakin.PasswordGenerator.controller;

import com.karyakin.PasswordGenerator.response.ErrorResponse;
import com.karyakin.PasswordGenerator.response.PasswordResponse;
import com.karyakin.PasswordGenerator.service.api.RandomPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PasswordGeneratorController {

    private final RandomPasswordGenerator randomPasswordGenerator;

    @RestController
    @Profile("dev")
    @RequiredArgsConstructor
    static class DevController {
        private final RandomPasswordGenerator randomPasswordGenerator;
        @GetMapping("/dev/api/v1/password/generate")
        public ResponseEntity<?> generateDevPassword(@RequestParam(required = false, defaultValue = "5") int lower, @RequestParam(required = false, defaultValue = "5") int upper,
                                                     @RequestParam(required = false, defaultValue = "3") int digit, @RequestParam(required = false, defaultValue = "3") int special) {
            try {
                return ResponseEntity.ok(new PasswordResponse(randomPasswordGenerator.generate(lower, upper, digit, special)));
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @Profile("master")
    @RequiredArgsConstructor
    static class DefaultController {
        private final RandomPasswordGenerator randomPasswordGenerator;
        @GetMapping("/api/v1/password/generate")
        public ResponseEntity<?> generatePassword(@RequestParam(required = false, defaultValue = "5") int lower, @RequestParam(required = false, defaultValue = "5") int upper,
                                                     @RequestParam(required = false, defaultValue = "3") int digit, @RequestParam(required = false, defaultValue = "3") int special) {
            try {
                return ResponseEntity.ok(new PasswordResponse(randomPasswordGenerator.generate(lower, upper, digit, special)));
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
            }
        }
    }
}
