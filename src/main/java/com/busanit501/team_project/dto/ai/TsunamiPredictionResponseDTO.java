package com.busanit501.team_project.dto.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TsunamiPredictionResponseDTO {

    @JsonProperty("prediction")
    private int prediction;

    @JsonProperty("tsunami_probability")
    private double probability;

    @JsonProperty("features")
    private TsunamiFeaturesDTO features;
}
