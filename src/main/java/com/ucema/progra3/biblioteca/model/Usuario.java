package com.ucema.progra3.biblioteca.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Debido a la poca agregación de atributos entre las clases hijas, se optó por utilizar SINGLE_TABLE
public abstract class Usuario implements UserDetails {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(nullable = false, length = 100)
    private String identificacion;

    @Column(nullable = false, length = 15, unique = true)
    private String dni;

    @Column(length = 100)
    private String email;

    @Column(name = "fecha_nacimiento") // Notar que redefinimos el nombre para seguir la convención de nombres de columnas en SQL
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;


    public Usuario(String username, String password, String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.prestamos = new ArrayList<>();
    }

    public Usuario() {

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public abstract LocalDate calcularFechaDevolucion(LocalDate date);

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean tienePrestamos() {
        return !this.prestamos.isEmpty();
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole();
}
