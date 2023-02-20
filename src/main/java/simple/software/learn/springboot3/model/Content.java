package simple.software.learn.springboot3.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDateTime;

public record Content(Integer id,
                      @NotBlank(message = "Digita o titulo, cabeção")
                      String title,
                      String desc,
                      Status status,
                      Type contentType,
                      LocalDateTime createdAt,
                      @Future
                      LocalDateTime updated,
                      String url) {
}
