package com.busanit501.team_project.service.ai;

import com.busanit501.team_project.dto.ai.TsunamiPredictionRequestDTO;
import com.busanit501.team_project.dto.ai.TsunamiPredictionResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
@RequiredArgsConstructor
public class TsunamiPredictionServiceImpl implements TsunamiPredictionService {

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    @Value("http://127.0.0.1:5000")
    private String flaskServerUrl;

    @Override
    public TsunamiPredictionResponseDTO predict(TsunamiPredictionRequestDTO requestDTO) throws IOException {
        String jsonRequest = objectMapper.writeValueAsString(requestDTO);
        RequestBody body = RequestBody.create(jsonRequest, MediaType.parse("application/json; charset=utf-8"));

        String flaskEndpoint = "/predict/tsunami";

        Request request = new Request.Builder()
                .url(flaskServerUrl + flaskEndpoint)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorBody = response.body() != null ? response.body().string() : "Response body is null";
                log.error("플라스크 서버 오류 ({}): {}", response.code(), errorBody);
                throw new IOException("플라스크 서버에서 예기치 않은 응답: " + response);
            }
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, TsunamiPredictionResponseDTO.class);
        }
    }
}
