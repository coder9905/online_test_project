package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperSubjectFirstPayload {

    private UUID id;

    public HelperSubjectFirstPayload(List<UUID> subjectId) {
        this.subjectId = subjectId;
    }

    private UUID subjectOneId;

    public HelperSubjectFirstPayload(UUID id, UUID subjectOneId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
    }

    private List<UUID> subjectId;
}
