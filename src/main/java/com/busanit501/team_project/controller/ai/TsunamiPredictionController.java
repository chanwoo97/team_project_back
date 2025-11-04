package com.busanit501.team_project.controller.ai;

import com.busanit501.team_project.dto.ai.TsunamiPredictionRequestDTO;
import com.busanit501.team_project.dto.ai.TsunamiPredictionResponseDTO;
import com.busanit501.team_project.service.ai.TsunamiPredictionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/tsunami")
@RequiredArgsConstructor
@Log4j2
public class TsunamiPredictionController {

    private final TsunamiPredictionService tsunamiPredictionService;

    @PostMapping("/predict")
    public ResponseEntity<TsunamiPredictionResponseDTO> predict(
            @RequestBody TsunamiPredictionRequestDTO requestDTO) throws IOException {
        log.info("쓰나미 예측 요청 수신: {}", requestDTO);
        TsunamiPredictionResponseDTO responseDTO = tsunamiPredictionService.predict(requestDTO);
        log.info("플라스크 서버로부터 받은 응답: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
