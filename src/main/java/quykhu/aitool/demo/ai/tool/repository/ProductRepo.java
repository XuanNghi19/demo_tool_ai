package quykhu.aitool.demo.ai.tool.repository;

import com.pgvector.PGvector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quykhu.aitool.demo.ai.tool.entity.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products ORDER BY image_embedding <=> CAST(:vec AS vector) LIMIT :limit", nativeQuery = true)
    List<Product> findSimilarProducts(@Param("vec") String vec, @Param("limit") int limit);
}
