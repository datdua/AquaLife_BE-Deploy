package vn.fpt.edu.aqualife.service;

import java.math.BigDecimal;
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
import vn.fpt.edu.aqualife.repository.AquariumRepository;
import vn.fpt.edu.aqualife.repository.FishRepository;
import vn.fpt.edu.aqualife.repository.FoodRepository;
import vn.fpt.edu.aqualife.repository.MedicineRepository;
import vn.fpt.edu.aqualife.repository.ProductRepository;
import vn.fpt.edu.aqualife.service.impl.IProductService;

@Service
public class ProductService implements IProductService {
//     @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private FishRepository fishRepository;
//
//    @Autowired
//    private FoodRepository foodRepository;
//
//    @Autowired
//    private MedicineRepository medicineRepository;
//
//    @Autowired
//    private AquariumRepository aquariumRepository;
//
//    @Override
//    public Product createProduct(Product product) {
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Fish createFish(Fish fish) {
//        Product product = fish.getProduct();
//        product.setProductType(ProductType.Fish);
//        productRepository.save(product);
//        return fishRepository.save(fish);
//    }
//
//    @Override
//    public Food createFood(Food food) {
//        Product product = food.getProduct();
//        product.setProductType(ProductType.Food);
//        productRepository.save(product);
//        return foodRepository.save(food);
//    }
//
//    @Override
//    public Medicine createMedicine(Medicine medicine) {
//        Product product = medicine.getProduct();
//        product.setProductType(ProductType.Medicine);
//        productRepository.save(product);
//        return medicineRepository.save(medicine);
//    }
//
//    @Override
//    public Aquarium createAquarium(Aquarium aquarium) {
//        Product product = aquarium.getProduct();
//        product.setProductType(ProductType.Aquarium);
//        productRepository.save(product);
//        return aquariumRepository.save(aquarium);
//    }
//
//    @Override
//    public List<Product> searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy) {
//        List<Product> products;
//
//        if (keyword != null && !keyword.isEmpty()) {
//            products = productRepository.searchByProductName(keyword);
//        } else if (type != null) {
//            products = productRepository.findByProductType(type);
//        } else {
//            products = productRepository.findAll();
//        }
//
//        if (minPrice != null && maxPrice != null) {
//            BigDecimal minPriceBD = new BigDecimal(minPrice.toString());
//            BigDecimal maxPriceBD = new BigDecimal(maxPrice.toString());
//            products = products.stream()
//                .filter(p -> p.getPrice().compareTo(minPriceBD) >= 0 && p.getPrice().compareTo(maxPriceBD) <= 0)
//                .collect(Collectors.toList());
//        }
//
//        if (sortBy != null) {
//            products = switch (sortBy) {
//                case "priceAsc" -> products.stream()
//                    .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
//                    .collect(Collectors.toList());
//                case "priceDesc" -> products.stream()
//                    .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
//                    .collect(Collectors.toList());
//                case "name" -> products.stream()
//                    .sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()))
//                    .collect(Collectors.toList());
//                default -> products;
//            };
//        }
//
//        return products;
//    }
//
//    @Override
//    public Product updateProduct(Integer id, Product product) {
//        Product existing = productRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Product not found"));
//        existing.setProductName(product.getProductName());
//        existing.setPrice(product.getPrice());
//        existing.setQuantity(product.getQuantity());
//        existing.setProductStatus(product.getProductStatus());
//        existing.setDescription(product.getDescription());
//        existing.setImageUrl(product.getImageUrl());
//        return productRepository.save(existing);
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        productRepository.deleteById(id);
//    }

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
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product createFish(FishRequest fishRequest) {
        Product product = new Product();
        product.setProductName(fishRequest.getProduct().getProductName());
        product.setProductStatus(fishRequest.getProduct().getProductStatus());
        product.setImageUrl(fishRequest.getProduct().getImageUrl());
        product.setDescription(fishRequest.getProduct().getDescription());
        product.setQuantity(fishRequest.getProduct().getQuantity());
        product.setPrice(fishRequest.getProduct().getPrice());
        product.setProductType(ProductType.Fish);

        Product savedProduct = productRepository.save(product);

        Fish fish = new Fish();
        fish.setProductId(savedProduct.getProductId());
        fish.setFishType(fishRequest.getFishType());
        fish.setFishFood(fishRequest.getFishFood());
        fish.setColor(fishRequest.getColor());
        fish.setBehavior(fishRequest.getBehavior());
        fish.setTemperature(fishRequest.getTemperature());
        fish.setPH(fishRequest.getPH());
        fishRepository.save(fish);

        return savedProduct;
    }

    @Override
    public Product createFood(FoodRequest foodRequest) {
        Product product = new Product();
        product.setProductName(foodRequest.getProduct().getProductName());
        product.setProductStatus(foodRequest.getProduct().getProductStatus());
        product.setImageUrl(foodRequest.getProduct().getImageUrl());
        product.setDescription(foodRequest.getProduct().getDescription());
        product.setQuantity(foodRequest.getProduct().getQuantity());
        product.setPrice(foodRequest.getProduct().getPrice());
        product.setProductType(ProductType.Food);

        Product savedProduct = productRepository.save(product);

        Food food = new Food();
        food.setProductId(savedProduct.getProductId());
        food.setFoodType(foodRequest.getFoodType());
        food.setPH(foodRequest.getPH());
        foodRepository.save(food);

        return savedProduct;
    }

    @Override
    public Product createMedicine(MedicineRequest medicineRequest) {
        Product product = new Product();
        product.setProductName(medicineRequest.getProduct().getProductName());
        product.setProductStatus(medicineRequest.getProduct().getProductStatus());
        product.setImageUrl(medicineRequest.getProduct().getImageUrl());
        product.setDescription(medicineRequest.getProduct().getDescription());
        product.setQuantity(medicineRequest.getProduct().getQuantity());
        product.setPrice(medicineRequest.getProduct().getPrice());
        product.setProductType(ProductType.Medicine);

        Product savedProduct = productRepository.save(product);

        Medicine medicine = new Medicine();
        medicine.setProductId(savedProduct.getProductId());
        medicine.setMedicineType(medicineRequest.getMedicineType());
        medicineRepository.save(medicine);

        return savedProduct;
    }

    @Override
    public Product createAquarium(AquariumRequest aquariumRequest) {
        Product product = new Product();
        product.setProductName(aquariumRequest.getProduct().getProductName());
        product.setProductStatus(aquariumRequest.getProduct().getProductStatus());
        product.setImageUrl(aquariumRequest.getProduct().getImageUrl());
        product.setDescription(aquariumRequest.getProduct().getDescription());
        product.setQuantity(aquariumRequest.getProduct().getQuantity());
        product.setPrice(aquariumRequest.getProduct().getPrice());
        product.setProductType(ProductType.Aquarium);

        Product savedProduct = productRepository.save(product);

        Aquarium aquarium = new Aquarium();
        aquarium.setProductId(savedProduct.getProductId());
        aquarium.setSize(aquariumRequest.getSize());
        aquariumRepository.save(aquarium);

        return savedProduct;
    }

    @Override
    public List<Product> searchProducts(String keyword, ProductType type, Double minPrice, Double maxPrice, String sortBy) {
        List<Product> products;

        if (keyword != null && !keyword.isEmpty()) {
            products = productRepository.searchByProductName(keyword);
        } else if (type != null) {
            products = productRepository.findByProductType(type);
        } else {
            products = productRepository.findAll();
        }

        if (minPrice != null && maxPrice != null) {
            BigDecimal minPriceBD = new BigDecimal(minPrice.toString());
            BigDecimal maxPriceBD = new BigDecimal(maxPrice.toString());
            products = products.stream()
                    .filter(p -> p.getPrice().compareTo(minPriceBD) >= 0 && p.getPrice().compareTo(maxPriceBD) <= 0)
                    .collect(Collectors.toList());
        }

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

        return products;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setProductName(product.getProductName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setProductStatus(product.getProductStatus());
        existing.setDescription(product.getDescription());
        existing.setImageUrl(product.getImageUrl());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
