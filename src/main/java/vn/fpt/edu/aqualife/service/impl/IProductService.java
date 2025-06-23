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

public interface IProductService {
//    Product createProduct(Product product);
//    Fish createFish(Fish fish);
//    Food createFood(Food food);
//    Medicine createMedicine(Medicine medicine);
//    Aquarium createAquarium(Aquarium aquarium);
//    List<Product> searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy);
//    Product updateProduct(Integer id, Product product);
//    void deleteProduct(Integer id);
    Product createProduct(Product product);
    Product createFish(FishRequest fishRequest);
    Product createFood(FoodRequest foodRequest);
    Product createMedicine(MedicineRequest medicineRequest);
    Product createAquarium(AquariumRequest aquariumRequest);
    List<Product> searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy);
    Product updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
}
