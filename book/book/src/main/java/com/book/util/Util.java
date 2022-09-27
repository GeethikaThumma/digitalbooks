package com.book.util;

import java.util.Random;

public class Util {
	
	public static int getSubId() {
		return  new Random().nextInt(900000) + 100000;
	}

}
