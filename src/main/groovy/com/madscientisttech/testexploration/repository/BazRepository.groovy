package com.madscientisttech.testexploration.repository

import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

import javax.annotation.PostConstruct

@Component
class BazRepository {
    @PostConstruct
    private void postConstruct() {
        throw new RuntimeException('should never get here in tests.')
    }

    def String getSingleWord() { "word" }
}
