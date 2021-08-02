package py.una.fiuna.evaluacion.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import py.una.fiuna.evaluacion.modelos.Personas;
import py.una.fiuna.evaluacion.modelos.Rol;
import py.una.fiuna.evaluacion.modelos.Usuario;

import py.una.fiuna.evaluacion.util.ApplicationContextProvider;
import py.una.fiuna.evaluacion.util.Mensaje;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;


@Controller
public class LoginController {

 /*   @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    private ApplicationContextProvider applicationContext;


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDto nuevoUsuarioDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuarioDto.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Usuario usuario =
                new Usuario( nuevoUsuarioDto.getNombreUsuario(),
                        passwordEncoder.encode(nuevoUsuarioDto.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuarioDto.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@Valid @RequestBody LoginUsuarioDto loginUsuarioDto, BindingResult bindingResult, HttpSession httpSession, HttpServletRequest request){
        Map<String, String> resultado  = new HashMap<>();

        if(bindingResult.hasErrors())
            return new ResponseEntity("verifique usuario y/o contraseña", HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuarioDto.getNombreUsuario(), loginUsuarioDto.getPassword()));
        if(authentication.isAuthenticated())
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            UsuarioDto usuarioDto = new UsuarioDto(userDetails.getUsername(), userDetails.getAuthorities());
            Usuario us = usuarioService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get();
            //applicationContext.getApplicationContext().getBean(Usuario.class);

            usuarioService.saveLoginInfo(us,request.getRemoteAddr(), new Date());
            httpSession.setAttribute("loggedInUser", usuarioDto);
            httpSession.setMaxInactiveInterval(3600);
            return new ResponseEntity(usuarioDto, HttpStatus.OK);



    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity Logout(HttpServletRequest request, SessionStatus
            status, HttpSession session, HttpServletResponse response) throws ServletException {
        SecurityContextHolder.getContext().setAuthentication(null);
        request.logout();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        request.getSession().invalidate();
        return new ResponseEntity("No has iniciado sesion!",HttpStatus.OK);
    }

    @RequestMapping(value = "/expired", method = RequestMethod.GET)
    public ResponseEntity Expired(HttpServletRequest request, SessionStatus
            status, HttpSession session, HttpServletResponse response) throws ServletException {
        SecurityContextHolder.getContext().setAuthentication(null);
        request.logout();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        request.getSession().invalidate();
        return new ResponseEntity("Sesion expirada!",HttpStatus.OK);
    }
*/


}
