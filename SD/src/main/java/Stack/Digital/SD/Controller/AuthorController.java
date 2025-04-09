package Stack.Digital.SD.Controller;

import Stack.Digital.SD.Entity.Author;
import Stack.Digital.SD.Service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService service;

    @PostMapping
    public ResponseEntity<Author> create(@Valid @RequestBody Author a) {
        return new ResponseEntity<>(service.create(a), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return service.get(id);
    }
    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @Valid @RequestBody Author a) {
        return service.update(id, a);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping public List<Author> list() {
        return service.list();
    }
}
