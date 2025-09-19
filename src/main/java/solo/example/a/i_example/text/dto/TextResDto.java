package solo.example.a.i_example.text.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import solo.example.a.i_example.text.entity.TextIndex;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TextResDto {
    private String title;
    private String contents;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static TextResDto fromEntity(TextIndex textIndex) {
        return TextResDto.builder()
                .title(textIndex.getTitle())
                .contents(textIndex.getContents())
                .createdDate(textIndex.getCreatedDate())
                .modifiedDate(textIndex.getModifiedDate())
                .build();
    }


}
