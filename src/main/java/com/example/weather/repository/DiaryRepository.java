package com.example.weather.repository;

import com.example.weather.domain.Diary;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

  List<Diary> findAllByDate(LocalDate date);

  Diary getFirstByDate(LocalDate date);

  @Transactional
  void deleteAllByDate(LocalDate date);

  List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
