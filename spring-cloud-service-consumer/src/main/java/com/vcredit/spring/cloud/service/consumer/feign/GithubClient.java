package com.vcredit.spring.cloud.service.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@FeignClient(name = "githubClient", url = "${github.client.url}")
public interface GithubClient {

    @GetMapping("/repos/{owner}/{repo}")
    GithubRepoInfo getRepo(@PathVariable String owner, @PathVariable String repo);

    class GithubRepoInfo {
        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
