package com.example.electricitybill.repository;

import com.example.electricitybill.model.MeterTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeterRepo extends CrudRepository<MeterTable, Integer> {
}
