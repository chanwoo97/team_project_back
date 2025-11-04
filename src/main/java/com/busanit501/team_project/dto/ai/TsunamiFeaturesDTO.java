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
public class TsunamiFeaturesDTO {
    // Flask key: "magnitude" (지진 규모)
    private double magnitude;

    // Flask key: "depth" (깊이)
    private double depth;

    // Flask key: "is_ocean" (바다 여부 - 1 또는 0)
    @JsonProperty("is_ocean")
    private int isOcean;

    // Flask key: "is_steep_slope" (가파른 경사 여부 - 1 또는 0)
    @JsonProperty("is_steep_slope")
    private int isSteepSlope;

    // Flask key: "horizontal_count_past_10y" (과거 10년 수평 단층 횟수)
    @JsonProperty("horizontal_count_past_10y")
    private int horizontalCountPast10y;

    // Flask key: "vertical_count_past_10y" (과거 10년 수직 단층 횟수)
    @JsonProperty("vertical_count_past_10y")
    private int verticalCountPast10y;
}
