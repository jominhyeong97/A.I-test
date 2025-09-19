package solo.example.a.i_example.text.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import solo.example.a.i_example.text.entity.TextIndex;

public interface TextRepository extends JpaRepository<TextIndex,Long> {

    Page<TextIndex> findAll(Pageable pageable);
}
