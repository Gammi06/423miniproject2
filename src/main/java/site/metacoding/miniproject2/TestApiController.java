package site.metacoding.miniproject2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestApiController {

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }
}
