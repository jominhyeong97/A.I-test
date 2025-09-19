package solo.example.a.i_example.text.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import solo.example.a.i_example.text.dto.TextPostDto;
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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {

        return new ResponseEntity<>(textService.get(id),HttpStatus.OK);
    }

}
