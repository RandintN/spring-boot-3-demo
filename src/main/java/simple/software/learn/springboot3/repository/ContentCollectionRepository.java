package simple.software.learn.springboot3.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import simple.software.learn.springboot3.model.Content;
import simple.software.learn.springboot3.model.Status;
import simple.software.learn.springboot3.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "Kotlin para Desenvolvedores Java",
                "Aprenda Kotlin através de exemplos reais",
                Status.IDEA,
                Type.COURSE,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(90L),
                "ipfs"
        );
        Content c2 = new Content(
                2,
                "A verdade sobre o Mercado de Tecnologia",
                "Através de analogias com outras industrias, verá como você não é especial",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(90L),
                "https"
        );
        contents.add(c);
        contents.add(c2);
    }

    public void save(Content content) {
        contents.removeIf(c -> c.id().equals(content.id()));
        contents.add(content);
    }

    public boolean existsById(Integer id) {
        return contents.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void remove(Integer id) {
        contents.removeIf(c -> c.id().equals(id));
    }
}
