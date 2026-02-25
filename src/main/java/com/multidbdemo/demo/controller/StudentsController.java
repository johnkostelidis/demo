package com.multidbdemo.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StudentsController {
    
    @Value("${spring.datasource.primary.url}")
    private String db1Url;

    @Value("${spring.datasource.secondary.url}")
    private String db2Url;

    @Value("${spring.datasource.primary.username}")
    private String dbUser;

    @Value("${spring.datasource.primary.password}")
    private String dbPassword;

    @GetMapping("/people")
    public List<Map<String, Object>> getPeople(@RequestParam(defaultValue = "J") String namePrefix) {
        List<Map<String, Object>> everyone = new ArrayList<>();
        
       
        everyone.addAll(searchDatabase(db1Url, namePrefix));
        
       
        everyone.addAll(searchDatabase(db2Url, namePrefix));

        
        return everyone;
    }

    private List<Map<String, Object>> searchDatabase(String dbUrl, String prefix) {
        List<Map<String, Object>> results = new ArrayList<>();
        
        String sql = "SELECT id, name, role FROM users WHERE name LIKE ?";
        
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, prefix + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Map<String, Object> person = new HashMap<>();
                person.put("id", rs.getInt("id"));
                person.put("name", rs.getString("name"));
                person.put("role", rs.getString("role"));
                results.add(person);
            }
        } catch (Exception e) {
            System.out.println("Database Error on " + dbUrl + ": " + e.getMessage());
        }
        return results;
    }
}
