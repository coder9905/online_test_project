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
public class HelperSubjectSecondPayload {

    private UUID id;

    public HelperSubjectSecondPayload(List<UUID> subjectId, UUID helperSubjectFirstId) {
        this.subjectId = subjectId;
        this.helperSubjectFirstId = helperSubjectFirstId;
    }

    private List<UUID> subjectId;

    private Subject subject;

    public HelperSubjectSecondPayload(UUID id, Subject subject) {
        this.id = id;
        this.subject = subject;
    }

    private UUID subjectOneId;

    public HelperSubjectSecondPayload(UUID id, UUID subjectOneId, UUID helperSubjectFirstId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
        this.helperSubjectFirstId = helperSubjectFirstId;
    }

    private UUID helperSubjectFirstId;

}
