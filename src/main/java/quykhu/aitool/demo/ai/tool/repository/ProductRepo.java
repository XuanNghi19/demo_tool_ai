package quykhu.aitool.demo.ai.tool.repository;

import com.pgvector.PGvector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quykhu.aitool.demo.ai.tool.entity.Products;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {

    @Query(value = "SELECT * FROM products ORDER BY image_embedding <-> :vec LIMIT :limit", nativeQuery = true)
    List<Products> findSimilarProducts(@Param("vec") PGvector vec, @Param("limit") int limit);

}
