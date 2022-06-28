package com.alrazihi.arangodb;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArticleResource {
    private final Logger log = LoggerFactory.getLogger(ArticleResource.class);

    private final ArticleService articleService;

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * To create an article
     *
     * @param article
     * @return
     */
    @PostMapping("/articles")
    public Article create(@RequestBody Article article) {
        log.debug("Create an article with the properties {}", article);
        return articleService.save(article);
    }

    /**
     * To update an article
     *
     * @param article
     * @return
     */
    @PutMapping("/articles")
    public Article update(@RequestBody Article article) {
        log.debug("Update the article of title {} with the properties {}", article.getTitle(), article);
        return articleService.update(article);
    }

    /**
     * Get the list of all articles
     *
     * @return
     */
    @GetMapping("/articles")
    public Iterable<Article> list() {
        log.debug("We just get the list of articles one more time");
        return articleService.findAll();
    }

    /**
     * Find an article by its id
     *
     * @param id
     * @return
     */
    @GetMapping("/articles/{id}")
    public Optional<Article> findByTitle(@PathVariable @NotNull String id) {
        log.debug("Load the article of id: {}", id);
        return articleService.findOne(id);
    }

    /**
     * Delete an article by its title
     *
     * @param id
     */
    @DeleteMapping("/articles/{id}")
    public void deleteById(@PathVariable @NotNull String id) {
        log.debug("Delete the article of id: {}", id);
        articleService.delete(id);
    }
}
