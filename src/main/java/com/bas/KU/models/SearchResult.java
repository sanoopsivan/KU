/**
 * 
 */
package com.bas.KU.models;

import java.util.Collections;
import java.util.List;

/**
 * @author San
 *
 */
public class SearchResult {
	private int currentPage;
	private int totalPages;
	private List<User> userList;
	private boolean showAdditionalOptions;

	public boolean isShowAdditionalOptions() {
		return showAdditionalOptions;
	}

	public void setShowAdditionalOptions(boolean showAdditionalOptions) {
		this.showAdditionalOptions = showAdditionalOptions;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
