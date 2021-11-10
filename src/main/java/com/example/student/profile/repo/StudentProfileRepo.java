package com.example.student.profile.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.profile.model.StudentsDetails;

public interface StudentProfileRepo extends JpaRepository<StudentsDetails, String>
{

}
