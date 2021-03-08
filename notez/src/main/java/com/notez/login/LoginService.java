/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.login;

/**
 *
 * @author Dailan´s PC
 */
public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("Dajlan") && password.equals("1234"))
			return true;

		return false;
	}

}
