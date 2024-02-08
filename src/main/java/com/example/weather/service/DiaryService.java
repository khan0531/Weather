package com.example.weather.service;

import com.example.weather.repository.DiaryRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

  @Value("${openweathermap.key}")
  private String apiKey;

  private final DiaryRepository diaryRepository;

  public void createDiary(LocalDate date, String text) {
    //open weather map에서 날씨 데이터 가져옴
   String weather =  getWeatherString();

    // 받아온 날씨 json 파싱

    // 파싱된 데이터 + 일기 값 우리 db에 넣기
  }

  private String getWeatherString() {
    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

    try {
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      BufferedReader br;
      if (responseCode == 200) {
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      } else {
        br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
      }
      String inputLine;
      StringBuilder response = new StringBuilder();
      while((inputLine = br.readLine()) != null) {
        response.append(inputLine);
      }
      br.close();
      return response.toString();
    } catch (Exception e) {
      return "failed to get response";
    }
  }



}
