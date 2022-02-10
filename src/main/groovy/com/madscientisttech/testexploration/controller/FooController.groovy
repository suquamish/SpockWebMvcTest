package com.madscientisttech.testexploration.controller

import com.madscientisttech.testexploration.service.BarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/foo')
class FooController {

    @Autowired
    BarService barService

    @GetMapping(produces = 'application/json')
    Map word() {
        return barService.fetchWord()
    }
}
