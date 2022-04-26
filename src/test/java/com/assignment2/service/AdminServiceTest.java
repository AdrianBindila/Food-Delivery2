package com.assignment2.service;

import com.assignment2.model.Admin;
import com.assignment2.repository.AdminRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class AdminServiceTest {
    private AdminService adminService;
    @Mock
    private AdminRepository adminRepository;

    @Before
    public void setup(){
        adminService=new AdminService();
    }

    @Test
    public void testAdminFound(){

    }
}