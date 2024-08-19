package ufrn.br.springrestweb2024.domain;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import ufrn.br.springrestweb2024.domain.generic.AbstractEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLDelete(sql = "UPDATE pessoa SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Pessoa extends AbstractEntity {

    @NotBlank (message = "O nome não pode estar em branco.")
    String nome;
    @Min(value = 0, message = "A idade tem que ser maior que zero.")
    int idade;
    String dataNascimento;
    String sexo;
    boolean isAdmin = false;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;
}
