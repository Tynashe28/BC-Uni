package com.bc.uni.services;

import com.bc.uni.exceptions.ResourceNotFoundException;
import com.bc.uni.models.Lecturer;
import com.bc.uni.models.Role;
import com.bc.uni.repositories.LecturerRepository;
import com.bc.uni.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Data @Service @Slf4j @Transactional
public class LecturerService implements com.bc.uni.services.interfaces.LecturerService, UserDetailsService {


    private LecturerRepository lecturerRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Lecturer lecturer = lecturerRepository.findLecturerByUsername(username).orElseThrow(
                ()-> new ResourceNotFoundException("username","v",username)
        );
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        lecturer.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(lecturer.getUsername(),lecturer.getPassword(),authorities);
    }

    @Override
    public Lecturer registerLecturer(Lecturer lecturer) {
        System.out.println("lecturer.getName() = " + lecturer.getName());
        lecturer.setPassword(passwordEncoder.encode(lecturer.getPassword()));
        return this.lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer findLecturerById(long id){
        return this.lecturerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Lecturer","id",Long.toString(id))
        );
    }

    @Override
    public Role saveRole(Role name) {
        return this.roleRepository.save(name);
    }

    @Override
    public void saveRoleToLecturer(String lecturerUsername, String roleName) {
        Lecturer lecturer = this.lecturerRepository.findLecturerByUsername(lecturerUsername).orElseThrow(
                ()-> new ResourceNotFoundException("Lecturer Name","lecturerName",lecturerUsername)
        );
        Role role = this.roleRepository.findRoleByName(roleName);
        lecturer.getRoles().add(role);

    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return this.lecturerRepository.findAll();
    }

    @Override
    public Lecturer findLecturerByUsername(String username) {
        return this.lecturerRepository.findLecturerByUsername(username).orElseThrow();
    }
}
