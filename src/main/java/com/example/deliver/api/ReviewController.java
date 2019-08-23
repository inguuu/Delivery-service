package com.example.deliver.api;

import com.example.deliver.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ReviewController {
    private final MongoRepository mongoRepository;

    public ReviewController(MongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @PostMapping("/review")
    public ResponseEntity mongotest(@RequestBody ReviewReq review) {

        log.info("====================="+board.getTitle());
        mongoRepository.save(board);
        DefaultRes<Board> sm = new DefaultRes<>(HttpStatus.OK,"성공" );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }
//    @DeleteMapping("/review/{storeIdx}/{id}")
//    public ResponseEntity mongotest2() {
//        com.example.mongotest.model.Board board1 = new com.example.mongotest.model.Board();
//        board1.setContentIdx(1);// 뭘 지울지 기준을 준다.
//        mongoRepository.delete(board1);
//        return null;
//
//    }
//    @GetMapping("/review/{storeIdx}/{id}")
//    public ResponseEntity mongotest3() {
//
//        Iterable<com.example.mongotest.model.Board> boardlist = mongoRepository.findAll();
//        DefaultRes<Iterable<com.example.mongotest.model.Board>> sm = new DefaultRes<Iterable<com.example.mongotest.model.Board>>(HttpStatus.OK.value(),"성공",boardlist );
//        return new ResponseEntity<>(sm, HttpStatus.OK);
//
//    }
}
