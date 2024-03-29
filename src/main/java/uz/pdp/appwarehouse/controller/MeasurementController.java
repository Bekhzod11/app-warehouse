package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.servise.MeasurementService;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
@Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurementService(measurement);
        return result;



    }

}
