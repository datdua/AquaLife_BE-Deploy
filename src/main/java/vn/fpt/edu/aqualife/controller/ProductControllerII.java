package vn.fpt.edu.aqualife.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import vn.fpt.edu.aqualife.entity.Product;
import vn.fpt.edu.aqualife.enums.ProductType;
import vn.fpt.edu.aqualife.payload.request.AquariumRequest;
import vn.fpt.edu.aqualife.payload.request.FishRequest;
import vn.fpt.edu.aqualife.payload.request.FoodRequest;
import vn.fpt.edu.aqualife.payload.request.MedicineRequest;
import vn.fpt.edu.aqualife.service.impl.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerII {

//    @Autowired
//    private IProductService iproductService;
//
//    @PostMapping("/fish")
//    public ResponseEntity<Fish> createFish(@RequestBody Fish fish) {
//        return ResponseEntity.ok(iproductService.createFish(fish));
//    }
//
//    @PostMapping("/food")
//    public ResponseEntity<Food> createFood(@RequestBody Food food) {
//        return ResponseEntity.ok(iproductService.createFood(food));
//    }
//
//    @PostMapping("/medicine")
//    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
//        return ResponseEntity.ok(iproductService.createMedicine(medicine));
//    }
//
//    @PostMapping("/aquarium")
//    public ResponseEntity<Aquarium> createAquarium(@RequestBody Aquarium aquarium) {
//        return ResponseEntity.ok(iproductService.createAquarium(aquarium));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Product>> searchProducts(
//            @RequestParam(required = false) String keyword,
//            @RequestParam(required = false) ProductType type,
//            @RequestParam(required = false) Double minPrice,
//            @RequestParam(required = false) Double maxPrice,
//            @RequestParam(required = false) String sortBy) {
//        return ResponseEntity.ok(iproductService.searchProducts(keyword, type, minPrice, maxPrice, sortBy));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
//        return ResponseEntity.ok(iproductService.updateProduct(id, product));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
//        iproductService.deleteProduct(id);
//        return ResponseEntity.ok().build();
//    }

    @Autowired
    private IProductService iproductService;

    @PostMapping("/fish")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> createFish(@Valid @RequestBody FishRequest fishRequest) {
        return ResponseEntity.ok(iproductService.createFish(fishRequest));
    }

    @PostMapping("/food")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> createFood(@Valid @RequestBody FoodRequest foodRequest) {
        return ResponseEntity.ok(iproductService.createFood(foodRequest));
    }

    @PostMapping("/medicine")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> createMedicine(@Valid @RequestBody MedicineRequest medicineRequest) {
        return ResponseEntity.ok(iproductService.createMedicine(medicineRequest));
    }

    @PostMapping("/aquarium")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> createAquarium(@Valid @RequestBody AquariumRequest aquariumRequest) {
        return ResponseEntity.ok(iproductService.createAquarium(aquariumRequest));
    }

    @GetMapping
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ProductType type,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(iproductService.searchProducts(keyword, type, minPrice, maxPrice, sortBy));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return ResponseEntity.ok(iproductService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        iproductService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
