package com.example.RaporModule.Controller;

import com.example.RaporModule.Models.Role;
import com.example.RaporModule.Security.AuthenticationRequest;
import com.example.RaporModule.Security.AuthenticationResponse;
import com.example.RaporModule.Security.RegisterRequest;

import com.example.RaporModule.UserManagementService.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class UserManagementController {

    private final AuthenticationService service;
    /**
     * for saving users to the system
     * @param request contains user information
     * */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    /**
     * to see if a user already registered to the system
     * @param request contains user email and password for validation
     * */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(service.authenticate(request));

    }
    /**
     * to regenerate if a user's token expiration time is out
     * @param request send request to the system
     * @param response response to the request from the system
     * @throws IOException if operation fails system sends this
     * */
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
    /**
     * to delete user from the system
     * @param id user's id for determine which user is going to be selected
     * */
    @GetMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Integer id){
        service.deleteUserById(id);
    }
   /**
    * to change a user's role
    * @param role which role we want a user's role to be changed
    * @param userId which user we want to change
    * */
    @GetMapping("/updateUserRole/{userId}/{role}")
    public void updateUserRole(@PathVariable Role role,
                               @PathVariable Integer userId){
        service.updateUserRole(role,userId);
    }

}