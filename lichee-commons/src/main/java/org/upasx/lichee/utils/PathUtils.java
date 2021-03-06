/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public abstract class PathUtils {

	public static String getParent(String path) {
		if (StringUtils.isBlank(path)) {
			return StringUtils.EMPTY;
		}
		path = path.trim();
		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}
		int index = path.lastIndexOf("/");
		if (index < 0) {
			return StringUtils.EMPTY;
		} else if (index == 0) {
			return "/";
		} else {
			return path.substring(0, index);
		}
	}

	public static String join(String... paths) {
		StringBuilder sb = new StringBuilder(paths.length * 16);
		for (String path : paths) {
			path = path == null ? StringUtils.EMPTY : path.trim();
			if (StringUtils.isBlank(path) || StringUtils.equals(path, "/")) {
				continue;
			}
			if (!sb.toString().endsWith("/") && !path.startsWith("/")) {
				sb.append("/");
			} else if (sb.toString().endsWith("/") && path.startsWith("/")) {
				path = path.substring(1);
			}
			sb.append(path);
		}
		if (sb.length() == 0) {
			return "/";
		}
		String fullPath = sb.toString();
		if (fullPath.endsWith("/")) {
			return fullPath.substring(0, fullPath.length() - 1);
		}
		return fullPath;
	}
}
