package com.madscientisttech.testexploration.controller

import com.madscientisttech.testexploration.service.BarService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@AutoConfigureWebMvc
@WebMvcTest(FooController)
class FooControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @SpringBean
    BarService mockBarService = Mock()

    def 'status is 200 and response is correct json'() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get('/foo')).andReturn().response

        then:
        1 * mockBarService.fetchWord() >> [word: 'thingamahjig']
        response.status == HttpStatus.OK.value()
        response.contentAsString == '{"word":"thingamahjig"}'
    }
}
