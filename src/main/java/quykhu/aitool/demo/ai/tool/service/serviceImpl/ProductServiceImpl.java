package quykhu.aitool.demo.ai.tool.service.serviceImpl;

import com.pgvector.PGvector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import quykhu.aitool.demo.ai.tool.entity.Product;
import quykhu.aitool.demo.ai.tool.exception.IdInvalidException;
import quykhu.aitool.demo.ai.tool.repository.ProductRepo;
import quykhu.aitool.demo.ai.tool.service.AIService;
import quykhu.aitool.demo.ai.tool.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final AIService aiService;

    @Override
    public List<Product> visualSearch(MultipartFile file) throws IdInvalidException {
        PGvector pGvector = aiService.analyzeImg(file);
        if(pGvector == null) throw new IdInvalidException("Vector is null!");

        return productRepo.findSimilarProducts(pGvector.toString(), 5);
    }
}
