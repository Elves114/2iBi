package _iBi.Desafio.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String subRegiao;

    @Column(nullable = false)
    private Double area;
}