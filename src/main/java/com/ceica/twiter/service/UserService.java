package com.ceica.twiter.service;

import com.ceica.twiter.config.AppConfig;
import com.ceica.twiter.model.Authority;
import com.ceica.twiter.model.User;
import com.ceica.twiter.repository.AuthorityRepository;
import com.ceica.twiter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private AppConfig appConfig;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository,AppConfig appConfig) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        passwordEncoder = new BCryptPasswordEncoder();
        this.appConfig=appConfig;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRol_id())
        );
    }
    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Integer idrol) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(idrol==1)
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        else
            grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        return grantedAuthorities;
    }

    public void crearUsuario(User user) {
        //Encriptamos password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol_id(2);

        User newUser = userRepository.save(user);
    }


    private String guardarFotoServidor(MultipartFile file, String fileName) {
        String uploadDir =appConfig.getUserImageDirectory() ; // Cambia esto por la ruta real de tu carpeta
        String filePath = uploadDir + File.separator + fileName;
        try {
            file.transferTo(new File(filePath));
        } catch ( IOException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return fileName;
    }

    public void actualizarFoto(MultipartFile imageUser, User user) {
        String fileName=user.getId()+"-"+user.getUsername()+".jpg";
        String nombreFichero=guardarFotoServidor(imageUser,fileName);
        user.setUserimg(nombreFichero);
        userRepository.save(user);

    }
}
