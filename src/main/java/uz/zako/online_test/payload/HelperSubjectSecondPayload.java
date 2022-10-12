package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Subject;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperSubjectSecondPayload {

    private Long id;

    public HelperSubjectSecondPayload(List<Long> subjectId, Long helperSubjectFirstId) {
        this.subjectId = subjectId;
        this.helperSubjectFirstId = helperSubjectFirstId;
    }

    private List<Long> subjectId;

    private Subject subject;

    public HelperSubjectSecondPayload(Long id, Subject subject) {
        this.id = id;
        this.subject = subject;
    }

    private Long subjectOneId;

    public HelperSubjectSecondPayload(Long id, Long subjectOneId, Long helperSubjectFirstId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
        this.helperSubjectFirstId = helperSubjectFirstId;
    }

    private Long helperSubjectFirstId;

}
