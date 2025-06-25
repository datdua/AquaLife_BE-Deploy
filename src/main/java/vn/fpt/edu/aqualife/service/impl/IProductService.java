package vn.fpt.edu.aqualife.service.impl;

import java.util.List;

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
import vn.fpt.edu.aqualife.payload.response.ApiResponse;

public interface IProductService {

    ApiResponse createFish(FishRequest fishRequest);
    ApiResponse createFood(FoodRequest foodRequest);
    ApiResponse createMedicine(MedicineRequest medicineRequest);
    ApiResponse createAquarium(AquariumRequest aquariumRequest);
    ApiResponse searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy);
    ApiResponse updateFish(Integer id, FishRequest fishRequest);
    ApiResponse updateFood(Integer id, FoodRequest foodRequest);
    ApiResponse updateMedicine(Integer id, MedicineRequest medicineRequest);
    ApiResponse updateAquarium(Integer id, AquariumRequest aquariumRequest);
}
