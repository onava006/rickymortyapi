package com.onavarrete.rickymorty.model.util;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExtractor {

	public static Integer getIdFromLocationUrl(String url) {

		String regex = ".*/(\\d+)$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);

		Integer id;

		if (matcher.find()) {
			String extractedId = matcher.group(1);
			id = Integer.valueOf(extractedId);
		} else {
			throw new NoSuchElementException("Wrong URL parameter given, check the url sent");
		}
		return id;
	}
}
