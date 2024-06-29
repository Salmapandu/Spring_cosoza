package com.example.COSOZA.Registration.Services;


import com.example.COSOZA.Registration.Entity.Staff;
import com.example.COSOZA.Registration.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    public void deleteById(int staff_id) {
        staffRepository.deleteById(staff_id);
    }
    public Optional<Staff> findById(int staff_id) {
        return staffRepository.findById(staff_id);
    }
}
