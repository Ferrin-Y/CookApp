package com.ferrin.cookapp.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {
    public enum Role { ADMIN, USER }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe> favorites = new HashSet<>();

    // Constructors
    public User() {}

    public User(String username, String password, String name, String email, Role role) {
        this.username = username;
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public Role getRole() { return role; }
    public Set<Recipe> getFavorites() { return Collections.unmodifiableSet(favorites); }

    // Security methods
    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, passwordHash);
    }

    // Favorite management
    public void addFavorite(Recipe recipe) {
        favorites.add(recipe);
    }

    public void removeFavorite(Recipe recipe) {
        favorites.remove(recipe);
    }

    public boolean hasFavorite(Recipe recipe) {
        return favorites.contains(recipe);
    }
}