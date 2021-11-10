package com.example.student.profile.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.student.profile.model.StudentsDetails;

public interface StudentsInfoRepo extends CrudRepository<StudentsDetails, String>
{

}
