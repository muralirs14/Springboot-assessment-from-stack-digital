package Stack.Digital.SD.Service;

import Stack.Digital.SD.Entity.Books;
import Stack.Digital.SD.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
   public BookRepository repo;

    public Books create(Books b) { return repo.save(b); }
    public Books get(Long id) { return repo.findById(id).orElseThrow(); }
    public Books update(Long id, Books b) {
        b.setId(id); return repo.save(b);
    }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Books> list() { return repo.findAll(); }
    public Page<Books> search(String q, Pageable p) {
        return repo.findByTitleContainingIgnoreCaseOrAuthor_NameContainingIgnoreCase(q, q, p);
    }
}