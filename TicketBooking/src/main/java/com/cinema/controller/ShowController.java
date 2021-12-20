package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.ShowsDTO;
import com.cinema.dtotoentity.ShowsDtoToEntity;
import com.cinema.entity.Shows;
import com.cinema.exception.ShowException;
import com.cinema.service.ShowService;
@RestController
public class ShowController {
	@Autowired
	ShowService showservice;
	@Autowired
	ShowsDtoToEntity showsDtoToEntity;
	@PostMapping(value = "/addshow")
	
	public Shows addMovie(@RequestBody ShowsDTO shows) {
		return showservice.addShow(showsDtoToEntity.convertShowsDtoToEntity(shows));
	}
	
	@GetMapping("/showById/{showId}")
	public Shows getshowById(@PathVariable Integer showId) {
	Shows show = showservice.getShowId(showId);
		if (show != null) {
			return show;
		} else {
			throw new ShowException();
		}
	}

	
}
