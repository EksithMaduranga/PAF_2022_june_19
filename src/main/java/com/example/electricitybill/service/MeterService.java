package com.example.electricitybill.service;

import com.example.electricitybill.model.MeterTable;
import com.example.electricitybill.repository.MeterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeterService {

    List<MeterTable> getAllMeters();

    MeterTable getById(Integer meterId);

    void saveOrUpdate(MeterTable meterTable);

    void deleteMeter(Integer meterId);


}
