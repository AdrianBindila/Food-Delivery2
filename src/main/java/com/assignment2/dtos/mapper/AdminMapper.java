package com.assignment2.dtos.mapper;

import com.assignment2.dtos.AdminDTO;
import com.assignment2.model.Admin;

public class AdminMapper {
    private static final AdminMapper instance=new AdminMapper();
    private AdminMapper(){

    }

    public static AdminMapper getInstance() {
        return instance;
    }
    public AdminDTO convertToDTO(Admin admin){
        AdminDTO adminDTO=new AdminDTO();
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setPassword(admin.getPassword());
        if(admin.restaurant!=null){
            adminDTO.setRestaurant(RestaurantMapper.getInstance().convertToDTO(admin.getRestaurant()));
        }
        return adminDTO;
    }
}
