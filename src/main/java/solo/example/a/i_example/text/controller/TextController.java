package solo.example.a.i_example.text.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import solo.example.a.i_example.text.dto.TextPostDto;
import solo.example.a.i_example.text.dto.TextUpdateDto;
import solo.example.a.i_example.text.service.TextService;

@Controller
@RequiredArgsConstructor
public class TextController {

    public final TextService textService;

    @PostMapping("/post")
    public ResponseEntity<?> post(@Valid @RequestBody TextPostDto textPostDto) {
        textService.post(textPostDto);
        return new ResponseEntity<>("텍스트 등록이 완료되었습니다.",HttpStatus.CREATED);
    }


    @GetMapping("/getlist")
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(textService.getList(pageable),HttpStatus.OK);
    }

    // 상세보기
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {

        return new ResponseEntity<>(textService.get(id),HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TextUpdateDto textUpdateDto) {

        return new ResponseEntity<>(textService.update(id,textUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return new ResponseEntity<>(textService.delete(id)+" 번 텍스트 삭제가 완료되었습니다.",HttpStatus.OK);
    }

}
