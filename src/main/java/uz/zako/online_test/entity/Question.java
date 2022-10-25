package uz.zako.online_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Embeddable

public class Question extends AbstractEntity {

    @Column(columnDefinition = "TEXT")
    private String body;

    private Long degree;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonManagedReference
    private Subject subjectId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "questionId")
    @JsonIgnore
    private List<Answer> answersId;



}
