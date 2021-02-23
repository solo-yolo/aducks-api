package io.github.soloyolo;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin //TODO: specify actual domains
@RestController
public class TestController {

    @GetMapping("/foo")
    Object getFoo() {
        return Map.of("message", "bar");
    }
}
