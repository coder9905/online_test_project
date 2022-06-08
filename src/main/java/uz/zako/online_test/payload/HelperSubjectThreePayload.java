package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.zako.online_test.entity.Subject;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperSubjectThreePayload {

    private UUID id;

    private List<UUID> subjectId;

    private UUID subjectOneId;

    private UUID helperSubjectSecondId;

    private Subject subject;

    public HelperSubjectThreePayload(UUID id, Subject subject) {
        this.id = id;
        this.subject = subject;
    }

    public HelperSubjectThreePayload(List<UUID> subjectId, UUID helperSubjectSecondId) {
        this.subjectId = subjectId;
        this.helperSubjectSecondId = helperSubjectSecondId;
    }

    public HelperSubjectThreePayload(UUID id, UUID subjectOneId, UUID helperSubjectSecondId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
        this.helperSubjectSecondId = helperSubjectSecondId;
    }
}
