package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperSubjectFirstPayload {

    private Long id;

    public HelperSubjectFirstPayload(List<Long> subjectId) {
        this.subjectId = subjectId;
    }

    private Long subjectOneId;

    public HelperSubjectFirstPayload(Long id, Long subjectOneId) {
        this.id = id;
        this.subjectOneId = subjectOneId;
    }

    private List<Long> subjectId;
}
