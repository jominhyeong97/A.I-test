package solo.example.a.i_example.text.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import solo.example.a.i_example.text.entity.TextIndex;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TextPostDto {
    private String title;
    private String contents;

    public TextIndex toEntity() {
        return TextIndex.builder()
                .title(title)
                .contents(contents)
                .build();
    }
}
