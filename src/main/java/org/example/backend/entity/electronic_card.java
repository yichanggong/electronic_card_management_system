package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="tb_electronic_card")
public class electronic_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name",nullable = false,unique = true,length = 10)
    private String name;
    @Column(name = "workplace",nullable = false,unique = true,length = 30)
    private String workplace;
    @Column(name = "position",nullable = false,unique = true,length = 10)
    private String position;
    @Column(name = "telephone_number",length = 11)
    private String telephone_number;
    @Column(name = "email_address",length = 30)
    private String email_address;
    @Column(name = "create_time")
    private LocalDateTime create_time;
    @Column(name = "update_time")
    private LocalDateTime update_time;
    public electronic_card(){}
}