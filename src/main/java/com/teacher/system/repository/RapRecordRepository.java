package com.teacher.system.repository;

import com.teacher.system.domain.RapRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapRecordRepository extends JpaRepository<RapRecord, Integer> {
}
