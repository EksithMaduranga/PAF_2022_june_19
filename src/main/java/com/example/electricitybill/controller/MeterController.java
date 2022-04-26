package com.example.electricitybill.controller;

import com.example.electricitybill.model.MeterTable;
import com.example.electricitybill.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class MeterController {

    @Autowired
    MeterService meterService;

    @PostMapping("/save")
    public MeterTable save(@RequestBody MeterTable meterTable) {
        meterService.saveOrUpdate(meterTable);
        return meterTable;
    }

    @GetMapping("/listMeter")
    public List<MeterTable> list() {
        return meterService.getAllMeters();
    }

    @GetMapping("/listMeter/{meterId}")
    public MeterTable getById(@PathVariable Integer meterId) {
        return meterService.getById(meterId);
    }

    @DeleteMapping("/deleteMeter/{meterId}")
    public String deleteMeter(@PathVariable (value = "meterId") Integer meterId) {
        meterService.deleteMeter(meterId);
        return "Successfully Deleted Meter ID ="+meterId;
    }

}
