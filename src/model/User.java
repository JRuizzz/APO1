package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class User {

	private String id;
	private String name;
	private String nickname;
	private Calendar signUpDate;
	private DateFormat formatter;

	public User(String id, String name, String nickname, Calendar signUpDate) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.signUpDate = Calendar.getInstance();
		this.formatter = new SimpleDateFormat("dd/M/yyyy");

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Calendar getSignUpDate() {
		return signUpDate;
	}

	public String getSignUpDateFormated(){
		return formatter.format(this.signUpDate.getTime());
	}
	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}

}
