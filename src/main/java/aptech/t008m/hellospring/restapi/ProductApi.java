package aptech.t008m.hellospring.restapi;

import aptech.t008m.hellospring.entity.Product;
import aptech.t008m.hellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/products")
public class ProductApi {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getList() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Product> optionalAccount = productService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalAccount = productService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct = optionalAccount.get();
        // map object
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPrice(product.getPrice());
        return ResponseEntity.ok(productService.save(existProduct));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


