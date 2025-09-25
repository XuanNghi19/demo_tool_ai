package quykhu.aitool.demo.ai.tool.controllers;

import com.pgvector.PGvector;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import quykhu.aitool.demo.ai.tool.entity.Product;
import quykhu.aitool.demo.ai.tool.exception.IdInvalidException;
import quykhu.aitool.demo.ai.tool.service.AIService;
import quykhu.aitool.demo.ai.tool.service.ProductService;
import quykhu.aitool.demo.ai.tool.util.annotation.ApiMessage;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final ProductService productService;
    private final AIService aiService;

    @PostMapping(value = "/visual_search", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiMessage("Tim kiem nhung san pham tuong tu bang anh")
    public ResponseEntity<List<Product>> visualSearch(@RequestParam MultipartFile file) throws IdInvalidException {
        List<Product> productList = this.productService.visualSearch(file);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PostMapping(value = "/analyze_img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiMessage("Phan tich anh thanh vector dac trung")
    public ResponseEntity<PGvector> analyze(@RequestParam MultipartFile file) throws IdInvalidException {
        PGvector pGvector = this.aiService.analyzeImg(file);
        return ResponseEntity.status(HttpStatus.OK).body(pGvector);
    }
}
