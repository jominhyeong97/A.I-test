package solo.example.a.i_example.text.entity;

import jakarta.persistence.*;
import lombok.*;
import solo.example.a.i_example.text.dto.TextUpdateDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TextIndex extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    private String contents;

    public void updateText(TextUpdateDto textUpdateDto) {

        if(!textUpdateDto.getTitle().isBlank()) {
            this.title = textUpdateDto.getTitle();
        }

        if(textUpdateDto.getContents().isBlank()) {
            throw new IllegalArgumentException("콘텐츠를 입력해주세요");
        } else {
            this.contents = textUpdateDto.getContents();
        }
    }
}
