package Stack.Digital.SD.Controller;

import Stack.Digital.SD.Entity.Books;
import Stack.Digital.SD.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
   public BookService service;

    @PostMapping
    public ResponseEntity<Books> create(@Valid @RequestBody Books b) {
        return new ResponseEntity<>(service.create(b), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Books get(@PathVariable Long id) {
        return service.get(id);
    }
    @PutMapping("/{id}")
    public Books update(@PathVariable Long id, @Valid @RequestBody Books b) {
        return service.update(id, b);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping public List<Books> list() {
        return service.list();
    }
    @GetMapping("/search")
    public Page<Books> search(@RequestParam String q, Pageable p) {
        return service.search(q, p);
    }
}
