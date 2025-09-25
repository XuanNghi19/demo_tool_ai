package quykhu.aitool.demo.ai.tool.service;

import org.springframework.web.multipart.MultipartFile;
import quykhu.aitool.demo.ai.tool.entity.Product;
import quykhu.aitool.demo.ai.tool.exception.IdInvalidException;

import java.util.List;

public interface ProductService {
    List<Product> visualSearch(MultipartFile file) throws IdInvalidException;
}
