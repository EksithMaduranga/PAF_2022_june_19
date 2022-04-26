package com.example.electricitybill.service;

import com.example.electricitybill.model.MeterTable;
import com.example.electricitybill.repository.MeterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeterServiceImplement implements MeterService{
    @Autowired
    MeterRepo meterRepo;

    @Override
    public List<MeterTable> getAllMeters() {
        return (List<MeterTable>) meterRepo.findAll();
    }

    @Override
    public MeterTable getById(Integer meterId) {
        return meterRepo.findById(meterId).get();
    }

    @Override
    public void saveOrUpdate(MeterTable meterTable) {
        meterRepo.save(meterTable);
    }

    @Override
    public void deleteMeter(Integer meterId) {
        meterRepo.deleteById(meterId);
    }

}
