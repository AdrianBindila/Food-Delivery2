package com.assignment2.service;

import com.assignment2.dtos.RestaurantDTO;
import com.assignment2.model.Admin;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.AdminRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdminFound() {
        Admin admin=new Admin();
        admin.setUsername("Admin");
        admin.setPassword("123");
        when(adminService.adminRepository.findByUsernameAndPassword(admin.getUsername(),admin.getPassword()))
                .thenReturn(Optional.of(admin));
        Admin newAdmin=adminService.findAdmin(admin.getUsername(),admin.getPassword());
        assertEquals("Admin",newAdmin.getUsername());
    }

    @Test
    public void testAdminNotFound() {
        assertThrows(NoSuchElementException.class,
                ()-> adminService.findAdmin("dadad","adafw"));
    }

    @Test
    void addRestaurantToExistingAdmin() {
        Admin admin=new Admin();
        admin.setUsername("Admin");
        admin.setPassword("123");
        when(adminService.adminRepository.findByUsername(admin.getUsername()))
                .thenReturn(Optional.of(admin));
        when(adminService.adminRepository.findByUsernameAndPassword(admin.getUsername(),admin.getPassword()))
                .thenReturn(Optional.of(admin));
        RestaurantDTO restaurantDTO=new RestaurantDTO();
        restaurantDTO.setName("Hallo");
        adminService.addRestaurant(admin.getUsername(),restaurantDTO);
        Admin newAdmin=adminService.findAdmin(admin.getUsername(),admin.getPassword());
        assertEquals("Hallo",newAdmin.getRestaurant().getName());
    }
    @Test
    void addRestaurantToNonExistingAdmin() {
        assertThrows(NoSuchElementException.class,
                ()-> adminService.addRestaurant("nonexistent",new RestaurantDTO()));
    }
}