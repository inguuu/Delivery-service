package com.example.deliver.api;

import com.example.deliver.domain.Review;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.model.ReviewReq;
import com.example.deliver.repository.ReviewRepository;
import com.example.deliver.service.S3FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
import java.io.IOException;

@Slf4j
@RestController
public class ReviewController {

    private final S3FileUploadService s3FileUploadService;
    private final ReviewRepository reviewRepository;


    public ReviewController(S3FileUploadService s3FileUploadService,  ReviewRepository reviewRepository) {

        this.s3FileUploadService = s3FileUploadService;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/review")
    public ResponseEntity mongotest( ReviewReq reviewReq, @RequestPart(value ="imgFile",required = false) MultipartFile imgFile) throws IOException {


        try {
            Review review = new Review();
            review.setStoreIdx(reviewReq.getStoreIdx());
            review.setContent(reviewReq.getContent());
            review.setId(reviewReq.getId());
            review.setRatng(reviewReq.getRatng());
            review.setImg(s3FileUploadService.upload(imgFile));
            reviewRepository.save(review);
            DefaultRes<Review> sm = new DefaultRes<>(HttpStatus.OK,"리뷰 등록 성공" );
            return new ResponseEntity<>(sm, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @DeleteMapping("/review/{storeIdx}/{id}")
    public ResponseEntity mongotest2(@RequestParam("storeIdx") int storeIdx,@RequestParam("id") String id) {
        try {
        Review reviewr = new Review();
        reviewr.setStoreIdx(storeIdx);
        reviewr.setId(id);
        DefaultRes<Review> sm = new DefaultRes<>(HttpStatus.OK,"리뷰 삭제 성공");
        return new ResponseEntity<>(sm, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/review/{storeIdx}/{id}")
    public ResponseEntity mongotest3(@RequestParam("storeIdx") int storeIdx,@RequestParam("id") String id) {
        try {
        Iterable<Review> reviewlist = reviewRepository.findByStoreIdxAndId(storeIdx,id);
        DefaultRes<Iterable<Review>> sm = new DefaultRes<Iterable<Review>>(HttpStatus.OK.value(),"리뷰 조회 성공",reviewlist );
        return new ResponseEntity<>(sm, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
