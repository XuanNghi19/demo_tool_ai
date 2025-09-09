package quykhu.aitool.demo.ai.tool.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quykhu.aitool.demo.ai.tool.entity.Products;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {
    @Query(value = "SELECT id, title FROM products ORDER BY image_embedding <-> :vec LIMIT :k", nativeQuery = true)
    List<Object[]> knn(@Param("vec") PGvector vec, @Param("k") int k);
}
