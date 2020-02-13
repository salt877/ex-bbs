package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Article;

/**
 * articlesテーブルを操作するリポジトリクラスです.
 * @author rinashioda
 *
 */
@Repository
public class ArticleRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {

		Article article = new Article();

		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));

		return article;
	};

	/**
	 * 全件検索するメソッドです.
	 * @return 全件検索結果
	 */
	public List<Article> findAll() {

		String sql = "SELECT id,name,content FROM articles";

		List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER);
		
		return articleList;
	}
	
	/**
	 * 入力内容を挿入するメソッドです.
	 * @param article articleオブジェクト
	 */
	public void insert(Article article) {
		
		String sql = "INSERT INTO articles (name,content) VALUES(:name,:content)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		
		template.update(sql,param);
	}
}
