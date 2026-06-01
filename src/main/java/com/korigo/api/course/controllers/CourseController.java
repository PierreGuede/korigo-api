package com.korigo.api.course.controllers;

import com.korigo.api.course.dtos.CourseRequest;
import com.korigo.api.course.resources.CourseResource;
import com.korigo.api.course.services.CourseService;
import com.korigo.api.shared.controllers.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController extends AbstractCrudController<CourseRequest, CourseResource> {

    public CourseController(CourseService service) {
        super(service);
    }
}
