package db.schulung.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloController {
    @GetMapping("hallo/{name}")
    public String sayHello(
            @PathVariable String name,
            @RequestParam(defaultValue = "2") int n) {
        return "moin ".repeat(n) + name;
    }
}
