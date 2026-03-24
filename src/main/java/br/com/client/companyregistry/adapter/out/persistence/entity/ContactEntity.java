package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String email;
    private String phone;
    private String department;

    // Getters/Setters
    public String getName() { return name; } public void setName(String s) { name = s; }
    public String getRole() { return role; } public void setRole(String s) { role = s; }
    public String getEmail() { return email; } public void setEmail(String s) { email = s; }
    public String getPhone() { return phone; } public void setPhone(String s) { phone = s; }
    public String getDepartment() { return department; } public void setDepartment(String s) { department = s; }
}