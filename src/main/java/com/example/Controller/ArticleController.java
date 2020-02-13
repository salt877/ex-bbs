package com.example.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Article;
import com.example.Form.ArticleForm;
import com.example.Repository.ArticleRepository;

/**
 * articlesテーブルを操作するコントローラクラスです.
 * @author rinashioda
 *
 */
@Controller
@RequestMapping("")
public class ArticleController {
	
	@ModelAttribute
	private ArticleForm setupForm() {
		return new ArticleForm();
	}
	
	@Autowired
	private ArticleRepository articleRepository;
	
	/**
	 * リポジトリのfindAllメソッドを使って掲示板のトップページを表示します.
	 * @param model リクエストスコープ
	 * @return 掲示板トップページ
	 */
	@RequestMapping("")
	public String index(Model model) {
		
		List<Article> articleList = articleRepository.findAll();
		
		model.addAttribute("articleList",articleList);
				
		return "bbs";
	}
	
	/**
	 * リポジトリのinsertメソッドを使って記事を追加して表示します.
	 * @param form リクエストパラメータ
	 * @return トップページ
	 */
	@RequestMapping("/insert")
	public String insertArticle(ArticleForm form) {
		
		Article article = new Article();
		
		BeanUtils.copyProperties(form, article);
		
		articleRepository.insert(article);
					
		return "redirect:";
	}

}
