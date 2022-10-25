package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Subject;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperSubjectThreePayload {

    private Long id;

    private List<Long> subjectId;

    private Long subjectOneId;

    private Long helperSubjectSecondId;

    private Subject subject;

    public HelperSubjectThreePayload(Long id, Subject subject) {
        this.id = id;
        this.subject = subject;
    }

    public HelperSubjectThreePayload(Long id, Long subjectOneId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
    }

    public HelperSubjectThreePayload(List<Long> subjectId, Long helperSubjectSecondId) {
        this.subjectId = subjectId;
        this.helperSubjectSecondId = helperSubjectSecondId;
    }

    public HelperSubjectThreePayload(Long id, Long subjectOneId, Long helperSubjectSecondId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
        this.helperSubjectSecondId = helperSubjectSecondId;
    }
}
