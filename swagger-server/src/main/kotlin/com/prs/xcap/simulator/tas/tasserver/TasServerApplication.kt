package com.prs.xcap.simulator.tas.tasserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class TasServerApplication

fun main(args: Array<String>) {
	runApplication<TasServerApplication>(*args)
}
