package com.example.Domain;

import java.util.List;

/**
 * atriclesテーブルを表すドメインクラスです.
 * 
 * @author rinashioda
 *
 */
public class Article {

	/** 投稿ID */
	private Integer id;

	/** 投稿者名 */
	private String name;

	/** 記事内容 */
	private String content;

	/** 入力されたコメント */
	private List<Comment> commentList;

	public Article() {
	}

	public Article(Integer id, String name, String content, List<Comment> commentList) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.commentList = commentList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}
}
