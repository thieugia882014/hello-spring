//package aptech.t008m.hellospring.validation;
//
//
//import aptech.t008m.hellospring.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidatorContext;
//
//@Component
//public class ProductIDExistingValidator {
//    @Autowired
//    private ProductService productService;
//
//    @Override
//    public boolean isValid(Long productId, ConstraintValidatorContext context){
//        return Object.isNull(productId) || productService.findById(productId).isPresent();
//    }
//}
