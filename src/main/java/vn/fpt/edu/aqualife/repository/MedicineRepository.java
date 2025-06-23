package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    List<Medicine> findByMedicineType(String medicineType);
}