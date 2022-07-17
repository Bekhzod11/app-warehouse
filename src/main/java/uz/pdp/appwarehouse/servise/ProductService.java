package uz.pdp.appwarehouse.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.AttachmentRepository;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Autowired
    AttachmentRepository attachmentRepository;


    @Autowired
    MeasurementRepository measurementRepository;


public Result addProduct(ProductDto productDto){

    boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
    if (existsByNameAndCategoryId)
        return new Result("Bunday mahsulot ushbu kategoriyada bor",false);


    Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());

    if (!optionalCategory.isPresent())
        return  new Result("Bunday kategoriya mavjud emas",false);


    Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());

    if (!optionalAttachment.isPresent())
        return new Result("BUnday rsm mavjud emas",false);


    Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());


    if (!optionalMeasurement.isPresent())
        return  new Result("Bunday o'lchov birligi mavjud emas",false);
    Product product = new Product();
    product.setName(productDto.getName());
    product.setCode("1"); // todo generatsiya qilish kk
    product.setCategory(optionalCategory.get());
    product.setPhoto(optionalAttachment.get());
    product.setMeasurement(optionalMeasurement.get());
productRepository.save(product);
return new Result("Maxsulot saqlandi",true);

}
}
