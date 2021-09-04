package com.dcjobs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "all_job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String employerName;

    private String title;

    private  String description;

    private String company_name;

    @ElementCollection
    private List<String> locationList = new ArrayList<>();

    private Double Salary;

    private String minExpecrience;

    private String maxExperience;

    private String minEducation;

    private String industry;

    @ElementCollection
    private List<String> skillList = new ArrayList<>();


}
