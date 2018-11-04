package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.BaseballTeam;
import jp.co.sample.repository.BaseballTeamRepository;

@Controller
@Transactional
@RequestMapping("/baseballTeam")
public class BaseballTeamController {

	@Autowired
	private BaseballTeamRepository repository;

	@Autowired
	private HttpSession session;

	/**
	 * チーム名のリンクを表示.
	 * 
	 * @return 初期ページ表示。
	 */
	@RequestMapping("/index")
	public String index() {
		List<BaseballTeam> teamList = repository.findAll();
		session.setAttribute("teamList", teamList);

		// チームリストへ
		return "/baseball/viewTeamList";
	}

	@RequestMapping("/viewTeamDetail")
	public String viewTeamDetail(Integer id,Model model) {
		BaseballTeam detailTeam = repository.load(id);
		model.addAttribute("detailTeam",detailTeam);
		return "/baseball/viewTeamDetails";
	}

}
