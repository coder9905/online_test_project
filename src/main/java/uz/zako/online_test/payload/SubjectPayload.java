package uz.zako.online_test.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectPayload {

    private UUID id;

    private String name;

    public SubjectPayload(String name) {
        this.name = name;
    }
}
