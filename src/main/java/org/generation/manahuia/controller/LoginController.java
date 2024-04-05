package org.generation.manahuia.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; // Importación necesaria para @RestController
import java.util.Calendar;
import java.util.Date;
import com.generation.manahuia.model.Usuario;
import com.generation.manahuia.service.UsuarioService;
import com.generation.manahuia.config.JwtFilter;
import com.generation.manahuia.dto.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController // Indica que esta clase es un controlador REST
public class LoginController {
    //private final LoginService loginService;
    private final UsuarioService usuarioService;
    @Autowired
    
    /*public LoginController(LoginService loginService ) {
        this.loginService=loginService;
    }*/
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService=usuarioService;
    }//constructor
    
    
    @PostMapping("/login") // Especifica la ruta para el método POST
    public Token loginUser(@RequestBody Usuario usuario) throws ServletException {
        if(usuarioService.validateUser(usuario)) {
            System.out.println("Usuario válido "+usuario.getCorreo());
            return new Token(generateToken(usuario.getCorreo()),usuarioService.getTipoUsuario(usuario.getCorreo()));
        }//if
        throw new ServletException("Nombre de usuario o contraseña incorrectos "+usuario.getCorreo());
    }
    

    
    private String generateToken(String username) {
        Calendar calendar = Calendar.getInstance();//Fecha hora actual
        calendar.add(Calendar.HOUR, 10); // Pruebas
        //calendar.add(Calendar.MINUTE, 30);// Producción
        return Jwts.builder().setSubject(username).claim("role", "user")//'user'rol Admin para manahuia
        .setIssuedAt(new Date())
        .setExpiration(calendar.getTime())
        .signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
        .compact();
    }//generateToken
    
    
    /*
    //Get by ID
    @GetMapping (path= "{loginId}")
    public Login getLogin(@PathVariable("loginId") int loginId) {
        return loginService.getLogin(loginId);
    }
    
    //POST 
    @PostMapping
    public Login addLogin(@RequestBody Login login) {
        return loginService.addLogin(login);
    }
    */

}
