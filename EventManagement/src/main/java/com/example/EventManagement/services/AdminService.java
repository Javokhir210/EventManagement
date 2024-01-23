package com.example.EventManagement.services;
import com.example.EventManagement.dto.AdminDto;

import java.util.List;

public interface AdminService {
    List<AdminDto> findAllAdmins();

    AdminDto findAdminById(long adminId);

    boolean loginAdmin(String name, String password);
}
