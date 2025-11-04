package com.busanit501.team_project.service.ai;

import com.busanit501.team_project.dto.ai.TsunamiPredictionRequestDTO;
import com.busanit501.team_project.dto.ai.TsunamiPredictionResponseDTO;

import java.io.IOException;

public interface TsunamiPredictionService {
    TsunamiPredictionResponseDTO predict(TsunamiPredictionRequestDTO requestDTO) throws IOException;
}
