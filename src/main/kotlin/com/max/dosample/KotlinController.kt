package com.max.dosample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * WS-REST API /api/v2 controller
 *
 */
@RestController
@RequestMapping("/api/v2")
class KotlinController(private val sampleService: SampleService) {

    /**
     * WS-REST API GET ../test/{samplePathVariable}
     * @return http body
     *
     */
    @GetMapping("/test/{samplePathVariable}")
    fun getSampleList(@PathVariable samplePathVariable: String) : Map<String, Any> {
        return if ("right-path-value" == samplePathVariable) {
            val returnBody = HashMap<String, Any>()
            returnBody.put("returnedListKey", sampleService.sampleList)

            returnBody
        } else {
            HashMap()
        }
    }
}