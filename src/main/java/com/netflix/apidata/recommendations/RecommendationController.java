package com.netflix.apidata.recommendations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.apidata.entity.Title;
import com.netflix.apidata.repository.TitleRepository;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

	@Autowired
	private TitleRepository titleRepository;
	
	private Pageable topLimit = null;
	
	@GetMapping("/best")
	public ResponseEntity<List<Title>> getBestRatedTitles(@RequestParam(required = false) Integer top) {

		checkTopValueIsNull(top);

		List<Title> titles = titleRepository.findTitlesByBestRating(topLimit);

		if (titles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(titles, HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<Title>> getBestRatedTitlesByCategory(@PathVariable("id") Long id, @RequestParam(required = false) Integer top) {

		checkTopValueIsNull(top);

		List<Title> titles = titleRepository.findTitlesByCategoryAndBestRating(id, topLimit);

		if (titles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(titles, HttpStatus.OK);
	}
	
	private void checkTopValueIsNull(Integer top) {
		if (top != null) {
			topLimit = PageRequest.of(0, top);
		}
	}
	
}
