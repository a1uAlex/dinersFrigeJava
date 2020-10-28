package de.alex.dinersFrige.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Keyword {

    public Keyword(String keyword){
        this.keyword = keyword;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String keyword;

}
