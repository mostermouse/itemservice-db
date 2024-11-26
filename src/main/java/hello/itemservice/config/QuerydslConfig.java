package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepositoryV2;
import hello.itemservice.repository.jpa.JpaitemRepositoryV3;
import hello.itemservice.repository.jpa.SpringDataJpaItemRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager em;

    // ItemService 빈 등록
    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    // ItemRepository 빈 등록
    @Bean
    public ItemRepository itemRepository() {
        // SpringDataJpaItemRepository를 JpaItemRepositoryV2에 주입
        return new JpaitemRepositoryV3(em);
    }
}
