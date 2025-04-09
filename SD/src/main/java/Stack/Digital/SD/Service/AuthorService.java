package Stack.Digital.SD.Service;

import Stack.Digital.SD.Entity.Author;
import Stack.Digital.SD.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
   public  AuthorRepository repo;

    public Author create(Author a) {
        return repo.save(a);
    }
    public Author get(Long id) {
        return repo.findById(id).orElseThrow();
    }
    public Author update(Long id, Author a) {
        a.setId(id); return repo.save(a);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public List<Author> list() {
        return repo.findAll();
    }
}
