package com.example.weather.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Diary {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  private String weather;
  private String icon;
  private double temperature;
  private String text;
  private LocalDate date;
}
