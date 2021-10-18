package io.github.caiocldias.desenvolvedores.Desenvolvedores.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Desenvolvedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 1)
    @NotNull(message = "{sexo.obrigatorio}")
    private char sexo;

    @Column(nullable = true, length = 2)
    @NotNull(message = "{idade.obrigatorio}")
    private Integer idade;

    @Column(nullable = true)
    @NotNull(message = "{hobby.obrigatorio}")
    private String hobby;

    @Column(nullable = false, name = "data_nascimento")
    @NotNull(message = "{dtnascimento.obrigatorio}")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataNascimento;

}
