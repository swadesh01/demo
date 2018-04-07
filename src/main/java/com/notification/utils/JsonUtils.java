package com.notification.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	private JsonUtils() {
	}

	public static String getJsonStringFromObject(Object obj)
			throws IOException {
		StringWriter writer = new StringWriter();
		objectMapper.writeValue(writer, obj);
		return writer.toString();
	}

	public static <T> T getObjectFromJsonString(Class<T> clazz, String requestJson, String callingMethod)
			throws IOException {
		T t = null;
		try {
			InputStream is = new ByteArrayInputStream(requestJson.getBytes("UTF-8"));
			t = objectMapper.readValue(is, clazz);
		} catch (IOException e) {
			logger.error(e.getMessage() + " {} ",e);
			throw e;
		}
		return t;
	}

	public static <T> T getObjectFromJsonString(String json, Class<T> className)
			throws IOException {
		return getObjectFromJsonString(className, json, "null");
	}



}
