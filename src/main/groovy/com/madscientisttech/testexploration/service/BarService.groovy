package com.madscientisttech.testexploration.service

import com.madscientisttech.testexploration.repository.BazRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BarService {
    @Autowired
    BazRepository bazRepository

    Map fetchWord() { [word: bazRepository.getSingleWord()] }
}
