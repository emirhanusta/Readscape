package authorservice

import authorservice.client.RetreiveMessageErrorDecoder
import feign.Logger
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class AuthorServiceApplication{
	@Bean
	fun errorDecoder(): ErrorDecoder {
		return RetreiveMessageErrorDecoder()
	}

	@Bean
	fun feignLoggerLevel(): Logger.Level {
		return Logger.Level.FULL
	}
}

fun main(args: Array<String>) {
	runApplication<AuthorServiceApplication>(*args)
}
