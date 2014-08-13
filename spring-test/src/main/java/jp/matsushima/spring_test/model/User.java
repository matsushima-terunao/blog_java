package jp.matsushima.spring_test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユーザーマスタ。
 * 
 * @author 2013/10/15 matsushima
 */
@Entity
@Table(name = "user_mst")
public class User {

	/** ID: id, serial, , not null, IDX:, UQ:, PK:○, FK:,  */
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	/** ログインID: loginid, varchar(100), , not null, IDX:, UQ:, PK:, FK:,  */
	@Column(name = "loginid")
	private String loginid;

	/** パスワード: password, text, , not null, IDX:, UQ:, PK:, FK:,  */
	@Column(name = "password")
	private String password;

	/** 名前: name, text, , not null, IDX:, UQ:, PK:, FK:,  */
	@Column(name = "name")
	private String name;

	/**
	 * ID: id, serial, , not null, IDX:, UQ:, PK:○, FK:,を取得します。
	 * @return ID: id, serial, , not null, IDX:, UQ:, PK:○, FK:,
	 */
	public int getId() {
	    return id;
	}

	/**
	 * ID: id, serial, , not null, IDX:, UQ:, PK:○, FK:,を設定します。
	 * @param id ID: id, serial, , not null, IDX:, UQ:, PK:○, FK:,
	 */
	public void setId(int id) {
	    this.id = id;
	}

	/**
	 * ログインID: loginid, varchar(100), , not null, IDX:, UQ:, PK:, FK:,を取得します。
	 * @return ログインID: loginid, varchar(100), , not null, IDX:, UQ:, PK:, FK:,
	 */
	public String getLoginid() {
	    return loginid;
	}

	/**
	 * ログインID: loginid, varchar(100), , not null, IDX:, UQ:, PK:, FK:,を設定します。
	 * @param loginid ログインID: loginid, varchar(100), , not null, IDX:, UQ:, PK:, FK:,
	 */
	public void setLoginid(String loginid) {
	    this.loginid = loginid;
	}

	/**
	 * パスワード: password, text, , not null, IDX:, UQ:, PK:, FK:,を取得します。
	 * @return パスワード: password, text, , not null, IDX:, UQ:, PK:, FK:,
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * パスワード: password, text, , not null, IDX:, UQ:, PK:, FK:,を設定します。
	 * @param password パスワード: password, text, , not null, IDX:, UQ:, PK:, FK:,
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	/**
	 * 名前: name, text, , not null, IDX:, UQ:, PK:, FK:,を取得します。
	 * @return 名前: name, text, , not null, IDX:, UQ:, PK:, FK:,
	 */
	public String getName() {
	    return name;
	}

	/**
	 * 名前: name, text, , not null, IDX:, UQ:, PK:, FK:,を設定します。
	 * @param name 名前: name, text, , not null, IDX:, UQ:, PK:, FK:,
	 */
	public void setName(String name) {
	    this.name = name;
	}
}
