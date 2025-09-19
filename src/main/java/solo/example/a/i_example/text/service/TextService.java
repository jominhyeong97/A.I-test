package solo.example.a.i_example.text.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import solo.example.a.i_example.text.dto.TextPostDto;
import solo.example.a.i_example.text.dto.TextResDto;
import solo.example.a.i_example.text.entity.TextIndex;
import solo.example.a.i_example.text.repository.TextRepository;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TextService {
    public final TextRepository textRepository;

    public void post(TextPostDto textPostDto) {

        TextIndex textIndex = textPostDto.toEntity();
        if(textIndex!=null) {
            textRepository.save(textIndex);
        }
    }

    public Page<TextResDto> getList(Pageable pageable) {
        Page<TextIndex> dtoPage = textRepository.findAll(pageable);
        return dtoPage.map(TextResDto::fromEntity);
    }

    public TextResDto get(Long id) {
        TextIndex textIndex = textRepository.findById(id).orElseThrow(()->new EntityNotFoundException("해당 값 없습니다."));
        return TextResDto.fromEntity(textIndex);
    }
}
