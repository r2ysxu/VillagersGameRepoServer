package com.vgrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GameListController {

	@RequestMapping("home/gamelist")
	public String fetchGameListView() {
		return "gamelistView";
	}
}
