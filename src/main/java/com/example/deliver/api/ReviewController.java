package com.example.deliver.api;

import com.example.deliver.domain.Review;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.model.ReviewReq;
import com.example.deliver.service.S3FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class ReviewController {
    private final MongoRepository mongoRepository;
    private final S3FileUploadService s3FileUploadService;

    public ReviewController(MongoRepository mongoRepository, S3FileUploadService s3FileUploadService) {
        this.mongoRepository = mongoRepository;
        this.s3FileUploadService = s3FileUploadService;
    }

    @PostMapping("/review")
    public ResponseEntity mongotest( ReviewReq reviewReq, @RequestPart(value ="imgFile",required = false) MultipartFile imgFile) throws IOException {

        Review review = new Review();
        review.setContent(reviewReq.getContent());
        review.setId(reviewReq.getId());
        review.setRatng(reviewReq.getRatng());
        review.setImg(s3FileUploadService.upload(imgFile));
        mongoRepository.save(review);
        DefaultRes<Review> sm = new DefaultRes<>(HttpStatus.OK,"리뷰 등록 성공" );
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
    @GetMapping("/review/{storeIdx}/{id}")
    public ResponseEntity mongotest3(@RequestParam("storeIdx") int storeIdx,@RequestParam("id") String id) {


        Iterable<Review> reviewlist = mongoRepository.findAll();
        DefaultRes<Iterable<Review>> sm = new DefaultRes<Iterable<Review>>(HttpStatus.OK.value(),"성공",reviewlist );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }
}
