package uz.pdp.appwarehouse.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

public Result addMeasurementService(Measurement measurement) {
    boolean existByName = measurementRepository.existsByName(measurement.getName());
    if (existByName)
        return new Result("Bunday o'lchov birligi bot", false);
        measurementRepository.save(measurement);

        Result result = new Result();
        result.setMessage("Muvaqqatli saqlandi");
        result.setSuccess(true);
        return new Result("Muvaqqiyatli saqlandi");
        return  result;
}


}
