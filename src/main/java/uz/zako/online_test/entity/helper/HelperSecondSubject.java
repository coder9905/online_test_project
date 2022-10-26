package uz.zako.online_test.entity.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Subject;
import uz.zako.online_test.entity.abstractentity.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class HelperSecondSubject extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//    @JsonIgnore
    private HelperFirstSubject helperFirstSubject;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//    @JsonIgnore
    private Subject subject;

}
