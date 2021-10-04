package ru.mirea.springpizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Описание модели роли пользователя
 */
@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role implements GrantedAuthority{
    /** Id роли */
    @Id
    @Column(name = "role_id")
    @NonNull
    private Long id;

    /** Наименование роли */
    @Column(name = "role_name")
    @NonNull
    private String name;

    /** Пользователей с этой ролью */
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}