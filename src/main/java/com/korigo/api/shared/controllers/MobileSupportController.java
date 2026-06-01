package com.korigo.api.shared.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MobileSupportController {

    @GetMapping({"/api/swagger-ui", "/api/swagger-ui/", "/api/swagger-ui.html", "/api/swagger-ui/index.html"})
    public String redirectSwaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }

    @ResponseBody
    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "api", "KoriGo backend is reachable",
            "swaggerUi", "/swagger-ui/index.html",
            "swaggerUiApiAlias", "/api/swagger-ui/index.html"
        );
    }
}
