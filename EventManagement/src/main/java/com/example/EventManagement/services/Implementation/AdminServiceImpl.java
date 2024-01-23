package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.AdminDto;
import com.example.EventManagement.models.Admins;
import com.example.EventManagement.repository.AdminRepository;
import com.example.EventManagement.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        List<Admins> admins = adminRepository.findAll();
        return admins.stream().map(admins1 -> mapToAdminDto(admins1)).collect(Collectors.toList());
    }

    @Override
    public AdminDto findAdminById(long adminId) {
        Admins admins = adminRepository.findById(adminId).get();
        return mapToAdminDto(admins);
    }

    @Override
    public boolean loginAdmin(String name, String password) {
        return adminRepository.findByName(name).isPresent() && adminRepository.findByName(name).get().getPassword().equals(password);
    }

    private AdminDto mapToAdminDto(Admins admins){
        AdminDto adminDto = AdminDto.builder()
                .id(admins.getId())
                .name(admins.getName())
                .surname(admins.getSurname())
                .email(admins.getEmail())
                .phone(admins.getPhone())
                .photoUrl(admins.getPhotoUrl())
                .password(admins.getPassword())
                .build();
        return adminDto;
    }
}
