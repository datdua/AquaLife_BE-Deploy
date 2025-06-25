package vn.fpt.edu.aqualife.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import vn.fpt.edu.aqualife.payload.response.*;
import vn.fpt.edu.aqualife.repository.AquariumRepository;
import vn.fpt.edu.aqualife.repository.FishRepository;
import vn.fpt.edu.aqualife.repository.FoodRepository;
import vn.fpt.edu.aqualife.repository.MedicineRepository;
import vn.fpt.edu.aqualife.repository.ProductRepository;
import vn.fpt.edu.aqualife.service.impl.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private AquariumRepository aquariumRepository;

    @Override
    public ApiResponse createFish(FishRequest fishRequest) {
        try {
            // Create and save Product
            Product product = new Product();
            product.setProductName(fishRequest.getProduct().getProductName());
            product.setProductStatus(fishRequest.getProduct().getProductStatus());
            product.setImageUrl(fishRequest.getProduct().getImageUrl());
            product.setDescription(fishRequest.getProduct().getDescription());
            product.setQuantity(fishRequest.getProduct().getQuantity());
            product.setPrice(fishRequest.getProduct().getPrice());
            product.setProductType(ProductType.Fish);
            product.setCreatedAt(java.time.LocalDateTime.now());
            product.setChangeAt(java.time.LocalDateTime.now());

            Product savedProduct = productRepository.save(product);

            // Create and save Fish
            Fish fish = new Fish();
            fish.setProduct(savedProduct);
            fish.setFishType(fishRequest.getFishType());
            fish.setFishFood(fishRequest.getFishFood());
            fish.setColor(fishRequest.getColor());
            fish.setBehavior(fishRequest.getBehavior());
            fish.setTemperature(fishRequest.getTemperature());
            fish.setPH(fishRequest.getPH());
            fishRepository.save(fish);

            // Create FishResponse
            FishResponse fishResponse = new FishResponse();
            fishResponse.setProductName(savedProduct.getProductName());
            fishResponse.setProductStatus(savedProduct.getProductStatus());
            fishResponse.setImageUrl(savedProduct.getImageUrl());
            fishResponse.setDescription(savedProduct.getDescription());
            fishResponse.setQuantity(savedProduct.getQuantity());
            fishResponse.setPrice(savedProduct.getPrice());
            fishResponse.setProductType(savedProduct.getProductType());
            fishResponse.setFishType(fishRequest.getFishType());
            fishResponse.setFishFood(fishRequest.getFishFood());
            fishResponse.setColor(fishRequest.getColor());
            fishResponse.setBehavior(fishRequest.getBehavior());
            fishResponse.setTemperature(fishRequest.getTemperature());
            fishResponse.setPH(fishRequest.getPH());
            fishResponse.setCreatedAt(savedProduct.getCreatedAt());
            fishResponse.setChangedAt(savedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(201)
                    .message("Cá được tạo thành công")
                    .data(fishResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi tạo cá: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse createFood(FoodRequest foodRequest) {
        try {
            // Create and save Product
            Product product = new Product();
            product.setProductName(foodRequest.getProduct().getProductName());
            product.setProductStatus(foodRequest.getProduct().getProductStatus());
            product.setImageUrl(foodRequest.getProduct().getImageUrl());
            product.setDescription(foodRequest.getProduct().getDescription());
            product.setQuantity(foodRequest.getProduct().getQuantity());
            product.setPrice(foodRequest.getProduct().getPrice());
            product.setProductType(ProductType.Food);
            product.setCreatedAt(java.time.LocalDateTime.now());
            product.setChangeAt(java.time.LocalDateTime.now());

            Product savedProduct = productRepository.save(product);

            // Create and save Food
            Food food = new Food();
            food.setProductId(savedProduct.getProductId());
            food.setFoodType(foodRequest.getFoodType());
            food.setPH(foodRequest.getPH());
            foodRepository.save(food);

            // Create FoodResponse
            FoodResponse foodResponse = new FoodResponse();
            foodResponse.setProductName(savedProduct.getProductName());
            foodResponse.setProductStatus(savedProduct.getProductStatus());
            foodResponse.setImageUrl(savedProduct.getImageUrl());
            foodResponse.setDescription(savedProduct.getDescription());
            foodResponse.setQuantity(savedProduct.getQuantity());
            foodResponse.setPrice(savedProduct.getPrice());
            foodResponse.setProductType(savedProduct.getProductType());
            foodResponse.setFoodType(foodRequest.getFoodType());
            foodResponse.setPH(foodRequest.getPH());
            foodResponse.setCreatedAt(savedProduct.getCreatedAt());
            foodResponse.setChangedAt(savedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(201)
                    .message("Thức ăn được tạo thành công")
                    .data(foodResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi tạo thức ăn: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse createMedicine(MedicineRequest medicineRequest) {
        try {
            // Create and save Product
            Product product = new Product();
            product.setProductName(medicineRequest.getProduct().getProductName());
            product.setProductStatus(medicineRequest.getProduct().getProductStatus());
            product.setImageUrl(medicineRequest.getProduct().getImageUrl());
            product.setDescription(medicineRequest.getProduct().getDescription());
            product.setQuantity(medicineRequest.getProduct().getQuantity());
            product.setPrice(medicineRequest.getProduct().getPrice());
            product.setProductType(ProductType.Medicine);
            product.setCreatedAt(java.time.LocalDateTime.now());
            product.setChangeAt(java.time.LocalDateTime.now());

            Product savedProduct = productRepository.save(product);

            // Create and save Medicine
            Medicine medicine = new Medicine();
            medicine.setProductId(savedProduct.getProductId());
            medicine.setMedicineType(medicineRequest.getMedicineType());
            medicineRepository.save(medicine);

            // Create MedicineResponse
            MedicineResponse medicineResponse = new MedicineResponse();
            medicineResponse.setProductName(savedProduct.getProductName());
            medicineResponse.setProductStatus(savedProduct.getProductStatus());
            medicineResponse.setImageUrl(savedProduct.getImageUrl());
            medicineResponse.setDescription(savedProduct.getDescription());
            medicineResponse.setQuantity(savedProduct.getQuantity());
            medicineResponse.setPrice(savedProduct.getPrice());
            medicineResponse.setProductType(savedProduct.getProductType());
            medicineResponse.setMedicineType(medicineRequest.getMedicineType());
            medicineResponse.setCreatedAt(savedProduct.getCreatedAt());
            medicineResponse.setChangedAt(savedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(201)
                    .message("Thuốc được tạo thành công")
                    .data(medicineResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi tạo thuốc: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse createAquarium(AquariumRequest aquariumRequest) {
        try {
            // Create and save Product
            Product product = new Product();
            product.setProductName(aquariumRequest.getProduct().getProductName());
            product.setProductStatus(aquariumRequest.getProduct().getProductStatus());
            product.setImageUrl(aquariumRequest.getProduct().getImageUrl());
            product.setDescription(aquariumRequest.getProduct().getDescription());
            product.setQuantity(aquariumRequest.getProduct().getQuantity());
            product.setPrice(aquariumRequest.getProduct().getPrice());
            product.setProductType(ProductType.Aquarium);
            product.setCreatedAt(java.time.LocalDateTime.now());
            product.setChangeAt(java.time.LocalDateTime.now());

            Product savedProduct = productRepository.save(product);

            // Create and save Aquarium
            Aquarium aquarium = new Aquarium();
            aquarium.setProductId(savedProduct.getProductId());
            aquarium.setSize(aquariumRequest.getSize());
            aquariumRepository.save(aquarium);

            // Create AquariumResponse
            AquariumResponse aquariumResponse = new AquariumResponse();
            aquariumResponse.setProductName(savedProduct.getProductName());
            aquariumResponse.setProductStatus(savedProduct.getProductStatus());
            aquariumResponse.setImageUrl(savedProduct.getImageUrl());
            aquariumResponse.setDescription(savedProduct.getDescription());
            aquariumResponse.setQuantity(savedProduct.getQuantity());
            aquariumResponse.setPrice(savedProduct.getPrice());
            aquariumResponse.setProductType(savedProduct.getProductType());
            aquariumResponse.setSize(aquariumRequest.getSize());
            aquariumResponse.setCreatedAt(savedProduct.getCreatedAt());
            aquariumResponse.setChangedAt(savedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(201)
                    .message("Bể cá được tạo thành công")
                    .data(aquariumResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi tạo bể cá: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

//    @Override
//    public ApiResponse searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy) {
//        try {
//            List<Product> products;
//
//            // Tìm kiếm theo từ khóa, loại sản phẩm hoặc lấy tất cả
//            if (keyword != null && !keyword.isEmpty()) {
//                products = productRepository.searchByProductName(keyword);
//            } else if (type != null) {
//                products = productRepository.findByProductType(type);
//            } else {
//                products = productRepository.findAll();
//            }
//
//            // Lọc theo giá
//            if (minPrice != null && maxPrice != null) {
//                BigDecimal minPriceBD = new BigDecimal(minPrice.toString());
//                BigDecimal maxPriceBD = new BigDecimal(maxPrice.toString());
//                products = products.stream()
//                        .filter(p -> p.getPrice().compareTo(minPriceBD) >= 0 && p.getPrice().compareTo(maxPriceBD) <= 0)
//                        .collect(Collectors.toList());
//            }
//
//            // Sắp xếp theo yêu cầu
//            if (sortBy != null) {
//                products = switch (sortBy) {
//                    case "priceAsc" -> products.stream()
//                            .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
//                            .collect(Collectors.toList());
//                    case "priceDesc" -> products.stream()
//                            .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
//                            .collect(Collectors.toList());
//                    case "name" -> products.stream()
//                            .sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()))
//                            .collect(Collectors.toList());
//                    default -> products;
//                };
//            }
//
//            // Tạo ProductResponse cho từng sản phẩm
//            List<ProductResponse> productResponses = products.stream().map(product -> {
//                ProductResponse response = new ProductResponse();
//                response.setProductName(product.getProductName());
//                response.setProductStatus(product.getProductStatus());
//                response.setImageUrl(product.getImageUrl());
//                response.setDescription(product.getDescription());
//                response.setQuantity(product.getQuantity());
//                response.setPrice(product.getPrice());
//                response.setProductType(product.getProductType());
//                return response;
//            }).collect(Collectors.toList());
//
//            return ApiResponse.builder()
//                    .status(200)
//                    .message("Tìm kiếm sản phẩm thành công")
//                    .data(productResponses)
//                    .build();
//        } catch (Exception e) {
//            return ApiResponse.builder()
//                    .status(500)
//                    .message("Lỗi khi tìm kiếm sản phẩm: " + e.getMessage())
//                    .data(null)
//                    .build();
//        }
//    }
    @Override
    public ApiResponse searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy) {
        try {
            List<Product> products;

            // Tìm kiếm theo từ khóa, loại sản phẩm hoặc lấy tất cả
            if (keyword != null && !keyword.isEmpty()) {
                products = productRepository.searchByProductName(keyword);
            } else if (type != null) {
                products = productRepository.findByProductType(type);
            } else {
                products = productRepository.findAll();
            }

            // Lọc theo giá
            if (minPrice != null && maxPrice != null) {
                BigDecimal minPriceBD = new BigDecimal(minPrice.toString());
                BigDecimal maxPriceBD = new BigDecimal(maxPrice.toString());
                products = products.stream()
                        .filter(p -> p.getPrice().compareTo(minPriceBD) >= 0 && p.getPrice().compareTo(maxPriceBD) <= 0)
                        .collect(Collectors.toList());
            }

            // Sắp xếp theo yêu cầu
            if (sortBy != null) {
                products = switch (sortBy) {
                    case "priceAsc" -> products.stream()
                            .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                            .collect(Collectors.toList());
                    case "priceDesc" -> products.stream()
                            .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
                            .collect(Collectors.toList());
                    case "name" -> products.stream()
                            .sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()))
                            .collect(Collectors.toList());
                    default -> products;
                };
            }

            // Tạo danh sách response dựa trên ProductType
            List<Object> productResponses = new ArrayList<>();
            for (Product product : products) {
                switch (product.getProductType()) {
                    case Fish:
                        Fish fish = fishRepository.findById(product.getProductId()).orElse(null);
                        if (fish != null) {
                            FishResponse fishResponse = new FishResponse();
                            fishResponse.setProductName(product.getProductName());
                            fishResponse.setProductStatus(product.getProductStatus());
                            fishResponse.setImageUrl(product.getImageUrl());
                            fishResponse.setDescription(product.getDescription());
                            fishResponse.setQuantity(product.getQuantity());
                            fishResponse.setPrice(product.getPrice());
                            fishResponse.setProductType(product.getProductType());
                            fishResponse.setFishType(fish.getFishType());
                            fishResponse.setFishFood(fish.getFishFood());
                            fishResponse.setColor(fish.getColor());
                            fishResponse.setBehavior(fish.getBehavior());
                            fishResponse.setTemperature(fish.getTemperature());
                            fishResponse.setPH(fish.getPH());
                            fishResponse.setCreatedAt(product.getCreatedAt());
                            fishResponse.setChangedAt(product.getChangeAt());
                            productResponses.add(fishResponse);
                        }
                        break;
                    case Food:
                        Food food = foodRepository.findById(product.getProductId()).orElse(null);
                        if (food != null) {
                            FoodResponse foodResponse = new FoodResponse();
                            foodResponse.setProductName(product.getProductName());
                            foodResponse.setProductStatus(product.getProductStatus());
                            foodResponse.setImageUrl(product.getImageUrl());
                            foodResponse.setDescription(product.getDescription());
                            foodResponse.setQuantity(product.getQuantity());
                            foodResponse.setPrice(product.getPrice());
                            foodResponse.setProductType(product.getProductType());
                            foodResponse.setFoodType(food.getFoodType());
                            foodResponse.setPH(food.getPH());
                            foodResponse.setCreatedAt(product.getCreatedAt());
                            foodResponse.setChangedAt(product.getChangeAt());
                            productResponses.add(foodResponse);
                        }
                        break;
                    case Medicine:
                        Medicine medicine = medicineRepository.findById(product.getProductId()).orElse(null);
                        if (medicine != null) {
                            MedicineResponse medicineResponse = new MedicineResponse();
                            medicineResponse.setProductName(product.getProductName());
                            medicineResponse.setProductStatus(product.getProductStatus());
                            medicineResponse.setImageUrl(product.getImageUrl());
                            medicineResponse.setDescription(product.getDescription());
                            medicineResponse.setQuantity(product.getQuantity());
                            medicineResponse.setPrice(product.getPrice());
                            medicineResponse.setProductType(product.getProductType());
                            medicineResponse.setMedicineType(medicine.getMedicineType());
                            medicineResponse.setCreatedAt(product.getCreatedAt());
                            medicineResponse.setChangedAt(product.getChangeAt());
                            productResponses.add(medicineResponse);
                        }
                        break;
                    case Aquarium:
                        Aquarium aquarium = aquariumRepository.findById(product.getProductId()).orElse(null);
                        if (aquarium != null) {
                            AquariumResponse aquariumResponse = new AquariumResponse();
                            aquariumResponse.setProductName(product.getProductName());
                            aquariumResponse.setProductStatus(product.getProductStatus());
                            aquariumResponse.setImageUrl(product.getImageUrl());
                            aquariumResponse.setDescription(product.getDescription());
                            aquariumResponse.setQuantity(product.getQuantity());
                            aquariumResponse.setPrice(product.getPrice());
                            aquariumResponse.setProductType(product.getProductType());
                            aquariumResponse.setSize(aquarium.getSize());
                            aquariumResponse.setCreatedAt(product.getCreatedAt());
                            aquariumResponse.setChangedAt(product.getChangeAt());
                            productResponses.add(aquariumResponse);
                        }
                        break;
                }
            }

            return ApiResponse.builder()
                    .status(200)
                    .message("Tìm kiếm sản phẩm thành công")
                    .data(productResponses)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi tìm kiếm sản phẩm: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse updateFish(Integer id, FishRequest fishRequest) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy"));
            if (existingProduct.getProductType() != ProductType.Fish) {
                return ApiResponse.builder()
                        .status(400)
                        .message("Sản phẩm không phải là cá")
                        .data(null)
                        .build();
            }

            existingProduct.setProductName(fishRequest.getProduct().getProductName());
            existingProduct.setProductStatus(fishRequest.getProduct().getProductStatus());
            existingProduct.setImageUrl(fishRequest.getProduct().getImageUrl());
            existingProduct.setDescription(fishRequest.getProduct().getDescription());
            existingProduct.setQuantity(fishRequest.getProduct().getQuantity());
            existingProduct.setPrice(fishRequest.getProduct().getPrice());
            existingProduct.setChangeAt(java.time.LocalDateTime.now());
            existingProduct.setCreatedAt(existingProduct.getCreatedAt());
            Product updatedProduct = productRepository.save(existingProduct);

            Fish existingFish = fishRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Thông tin cá không tìm thấy"));
            existingFish.setFishType(fishRequest.getFishType());
            existingFish.setFishFood(fishRequest.getFishFood());
            existingFish.setColor(fishRequest.getColor());
            existingFish.setBehavior(fishRequest.getBehavior());
            existingFish.setTemperature(fishRequest.getTemperature());
            existingFish.setPH(fishRequest.getPH());
            fishRepository.save(existingFish);

            FishResponse fishResponse = new FishResponse();
            fishResponse.setProductName(updatedProduct.getProductName());
            fishResponse.setProductStatus(updatedProduct.getProductStatus());
            fishResponse.setImageUrl(updatedProduct.getImageUrl());
            fishResponse.setDescription(updatedProduct.getDescription());
            fishResponse.setQuantity(updatedProduct.getQuantity());
            fishResponse.setPrice(updatedProduct.getPrice());
            fishResponse.setProductType(updatedProduct.getProductType());
            fishResponse.setFishType(fishRequest.getFishType());
            fishResponse.setFishFood(fishRequest.getFishFood());
            fishResponse.setColor(fishRequest.getColor());
            fishResponse.setBehavior(fishRequest.getBehavior());
            fishResponse.setTemperature(fishRequest.getTemperature());
            fishResponse.setPH(fishRequest.getPH());
            fishResponse.setCreatedAt(updatedProduct.getCreatedAt());
            fishResponse.setChangedAt(updatedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(200)
                    .message("Cập nhật cá thành công")
                    .data(fishResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi cập nhật cá: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse updateFood(Integer id, FoodRequest foodRequest) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy"));
            if (existingProduct.getProductType() != ProductType.Food) {
                return ApiResponse.builder()
                        .status(400)
                        .message("Sản phẩm không phải là thức ăn")
                        .data(null)
                        .build();
            }

            existingProduct.setProductName(foodRequest.getProduct().getProductName());
            existingProduct.setProductStatus(foodRequest.getProduct().getProductStatus());
            existingProduct.setImageUrl(foodRequest.getProduct().getImageUrl());
            existingProduct.setDescription(foodRequest.getProduct().getDescription());
            existingProduct.setQuantity(foodRequest.getProduct().getQuantity());
            existingProduct.setPrice(foodRequest.getProduct().getPrice());
            existingProduct.setChangeAt(java.time.LocalDateTime.now());
            existingProduct.setCreatedAt(existingProduct.getCreatedAt());
            Product updatedProduct = productRepository.save(existingProduct);

            Food existingFood = foodRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Thông tin thức ăn không tìm thấy"));
            existingFood.setFoodType(foodRequest.getFoodType());
            existingFood.setPH(foodRequest.getPH());
            foodRepository.save(existingFood);

            FoodResponse foodResponse = new FoodResponse();
            foodResponse.setProductName(updatedProduct.getProductName());
            foodResponse.setProductStatus(updatedProduct.getProductStatus());
            foodResponse.setImageUrl(updatedProduct.getImageUrl());
            foodResponse.setDescription(updatedProduct.getDescription());
            foodResponse.setQuantity(updatedProduct.getQuantity());
            foodResponse.setPrice(updatedProduct.getPrice());
            foodResponse.setProductType(updatedProduct.getProductType());
            foodResponse.setFoodType(foodRequest.getFoodType());
            foodResponse.setPH(foodRequest.getPH());
            foodResponse.setCreatedAt(updatedProduct.getCreatedAt());
            foodResponse.setChangedAt(updatedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(200)
                    .message("Cập nhật thức ăn thành công")
                    .data(foodResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi cập nhật thức ăn: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse updateMedicine(Integer id, MedicineRequest medicineRequest) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy"));
            if (existingProduct.getProductType() != ProductType.Medicine) {
                return ApiResponse.builder()
                        .status(400)
                        .message("Sản phẩm không phải là thuốc")
                        .data(null)
                        .build();
            }

            existingProduct.setProductName(medicineRequest.getProduct().getProductName());
            existingProduct.setProductStatus(medicineRequest.getProduct().getProductStatus());
            existingProduct.setImageUrl(medicineRequest.getProduct().getImageUrl());
            existingProduct.setDescription(medicineRequest.getProduct().getDescription());
            existingProduct.setQuantity(medicineRequest.getProduct().getQuantity());
            existingProduct.setPrice(medicineRequest.getProduct().getPrice());
            existingProduct.setChangeAt(java.time.LocalDateTime.now());
            existingProduct.setCreatedAt(existingProduct.getCreatedAt());
            Product updatedProduct = productRepository.save(existingProduct);

            Medicine existingMedicine = medicineRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Thông tin thuốc không tìm thấy"));
            existingMedicine.setMedicineType(medicineRequest.getMedicineType());
            medicineRepository.save(existingMedicine);

            MedicineResponse medicineResponse = new MedicineResponse();
            medicineResponse.setProductName(updatedProduct.getProductName());
            medicineResponse.setProductStatus(updatedProduct.getProductStatus());
            medicineResponse.setImageUrl(updatedProduct.getImageUrl());
            medicineResponse.setDescription(updatedProduct.getDescription());
            medicineResponse.setQuantity(updatedProduct.getQuantity());
            medicineResponse.setPrice(updatedProduct.getPrice());
            medicineResponse.setProductType(updatedProduct.getProductType());
            medicineResponse.setMedicineType(medicineRequest.getMedicineType());
            medicineResponse.setCreatedAt(updatedProduct.getCreatedAt());
            medicineResponse.setChangedAt(updatedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(200)
                    .message("Cập nhật thuốc thành công")
                    .data(medicineResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi cập nhật thuốc: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse updateAquarium(Integer id, AquariumRequest aquariumRequest) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy"));
            if (existingProduct.getProductType() != ProductType.Aquarium) {
                return ApiResponse.builder()
                        .status(400)
                        .message("Sản phẩm không phải là bể cá")
                        .data(null)
                        .build();
            }

            existingProduct.setProductName(aquariumRequest.getProduct().getProductName());
            existingProduct.setProductStatus(aquariumRequest.getProduct().getProductStatus());
            existingProduct.setImageUrl(aquariumRequest.getProduct().getImageUrl());
            existingProduct.setDescription(aquariumRequest.getProduct().getDescription());
            existingProduct.setQuantity(aquariumRequest.getProduct().getQuantity());
            existingProduct.setPrice(aquariumRequest.getProduct().getPrice());
            existingProduct.setChangeAt(java.time.LocalDateTime.now());
            existingProduct.setCreatedAt(existingProduct.getCreatedAt());
            Product updatedProduct = productRepository.save(existingProduct);

            Aquarium existingAquarium = aquariumRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Thông tin bể cá không tìm thấy"));
            existingAquarium.setSize(aquariumRequest.getSize());
            aquariumRepository.save(existingAquarium);

            AquariumResponse aquariumResponse = new AquariumResponse();
            aquariumResponse.setProductName(updatedProduct.getProductName());
            aquariumResponse.setProductStatus(updatedProduct.getProductStatus());
            aquariumResponse.setImageUrl(updatedProduct.getImageUrl());
            aquariumResponse.setDescription(updatedProduct.getDescription());
            aquariumResponse.setQuantity(updatedProduct.getQuantity());
            aquariumResponse.setPrice(updatedProduct.getPrice());
            aquariumResponse.setProductType(updatedProduct.getProductType());
            aquariumResponse.setSize(aquariumRequest.getSize());
            aquariumResponse.setCreatedAt(updatedProduct.getCreatedAt());
            aquariumResponse.setChangedAt(updatedProduct.getChangeAt());

            return ApiResponse.builder()
                    .status(200)
                    .message("Cập nhật bể cá thành công")
                    .data(aquariumResponse)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .status(500)
                    .message("Lỗi khi cập nhật bể cá: " + e.getMessage())
                    .data(null)
                    .build();
        }
    }
}
