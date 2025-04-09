package Stack.Digital.SD.Repository;

import Stack.Digital.SD.Entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {
    Page<Books> findByTitleContainingIgnoreCaseOrAuthor_NameContainingIgnoreCase(String title, String author, Pageable pageable);
}