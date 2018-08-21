package com.example.blog

import org.slf4j.LoggerFactory

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {

    private val logger = LoggerFactory.getLogger(BlogApplication::class.java)

    @Bean
    fun initDatabase(articleRepository: ArticleRepository) = CommandLineRunner {

        if (logger.isInfoEnabled)
            logger.info("Start initializing database")

        val articles = listOf(
            Article("My First Article", "my 1st article content"),
            Article("My Second Article", "my 2nd article content"))
        articleRepository.saveAll(articles)

        if (logger.isInfoEnabled)
            logger.info("Done initializing database")
    }
}

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
