package quykhu.aitool.demo.ai.tool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestResponse<T> {
    private int statusCode;
    private Object error;
    private Object message;
    private T data;
}
