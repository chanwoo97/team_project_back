package com.busanit501.team_project.dto.ai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TsunamiPredictionRequestDTO {
    private double magnitude;
    private double depth;
    private double latitude;
    private double longitude;
}
