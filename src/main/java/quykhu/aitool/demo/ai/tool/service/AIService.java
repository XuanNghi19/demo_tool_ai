package quykhu.aitool.demo.ai.tool.service;

import com.pgvector.PGvector;
import org.springframework.web.multipart.MultipartFile;
import quykhu.aitool.demo.ai.tool.exception.IdInvalidException;

public interface AIService {
    PGvector analyzeImg(MultipartFile file) throws IdInvalidException;
}
