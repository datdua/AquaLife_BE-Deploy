package vn.fpt.edu.aqualife.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import vn.fpt.edu.aqualife.entity.Aquarium;
import vn.fpt.edu.aqualife.entity.Fish;
import vn.fpt.edu.aqualife.entity.Food;
import vn.fpt.edu.aqualife.entity.Medicine;
import vn.fpt.edu.aqualife.entity.Product;
import vn.fpt.edu.aqualife.enums.ProductType;
import vn.fpt.edu.aqualife.payload.request.AquariumRequest;
import vn.fpt.edu.aqualife.payload.request.FishRequest;
import vn.fpt.edu.aqualife.payload.request.FoodRequest;
import vn.fpt.edu.aqualife.payload.request.MedicineRequest;
import vn.fpt.edu.aqualife.service.impl.IProductService;
import vn.fpt.edu.aqualife.payload.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private IProductService iproductService;

    @PostMapping("/fish")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> createFish(@Valid @RequestBody FishRequest fishRequest) {
        ApiResponse response = iproductService.createFish(fishRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/food")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> createFood(@Valid @RequestBody FoodRequest foodRequest) {
        ApiResponse response = iproductService.createFood(foodRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/medicine")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> createMedicine(@Valid @RequestBody MedicineRequest medicineRequest) {
        ApiResponse response = iproductService.createMedicine(medicineRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }


    @PostMapping("/aquarium")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> createAquarium(@Valid @RequestBody AquariumRequest aquariumRequest) {
        ApiResponse response = iproductService.createAquarium(aquariumRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse> searchProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ProductType type,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String sortBy) {
        ApiResponse response = iproductService.searchProducts(keyword, type, minPrice, maxPrice, sortBy);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

//    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
//        ApiResponse response = iproductService.updateProduct(id, product);
//        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
//    }
    @PutMapping("/fish/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> updateFish(@PathVariable Integer id, @Valid @RequestBody FishRequest fishRequest) {
        ApiResponse response = iproductService.updateFish(id, fishRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/food/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> updateFood(@PathVariable Integer id, @Valid @RequestBody FoodRequest foodRequest) {
        ApiResponse response = iproductService.updateFood(id, foodRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/medicine/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> updateMedicine(@PathVariable Integer id, @Valid @RequestBody MedicineRequest medicineRequest) {
        ApiResponse response = iproductService.updateMedicine(id, medicineRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @PutMapping("/aquarium/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> updateAquarium(@PathVariable Integer id, @Valid @RequestBody AquariumRequest aquariumRequest) {
        ApiResponse response = iproductService.updateAquarium(id, aquariumRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
