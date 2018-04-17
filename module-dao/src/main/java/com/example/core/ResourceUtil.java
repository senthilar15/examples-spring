package com.example.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.util.StringUtils;

public class ResourceUtil {

	
	public static InputStream loadFromClasspath(String fileClasspath) {
		fileClasspath = fixResourceClasspath(fileClasspath);
		URL url = findResource(Thread.currentThread().getContextClassLoader(), fileClasspath);
		if (url == null) {
			return null;
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String fixResourceClasspath(String resourcePath) {
		if (StringUtils.startsWithIgnoreCase(resourcePath, "/")) {
			return resourcePath.substring(1);
		}
		return resourcePath;
	}

	private static URL findResource(ClassLoader classLoader, String resourcePath) {
		URL url = classLoader.getResource(resourcePath);
		if (url == null && classLoader.getParent() != null) {
			url = findResource(classLoader.getParent(), resourcePath);
		}
		return url;
	}

	
	
}
