package com.prs.xcap.simulator.tas.tasserver.rest

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/services")
@Api(value = "Tas", description = "API for manipulate Serve Doc")
class SimServiceResource {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    val response: String

    init {
        response = loadXml()
    }

    private final fun loadXml(): String {
        return ResourceUtils.getFile("classpath:simServe.xml")
                .readLines()
                .joinToString(separator = "")
    }

    @ApiOperation(value = "Get updated doc", response = Iterable::class)
    @ApiResponses(value = [ApiResponse(code = 200, message = "Successfully retrieved Doc"), ApiResponse(code = 401, message = "You are not authorized to view the resource"), ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"), ApiResponse(code = 404, message = "The resource you were trying to reach is not found")])
    @PostMapping("/get", produces = ["application/vnd.etsi.simservs+xml;charset=UTF-8"])
    fun simServe(): String {
        logger.debug("Request received for $response")

        return "$response"
    }

}
