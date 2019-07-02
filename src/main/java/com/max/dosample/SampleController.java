package com.max.dosample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

	private SampleService sampleService;

	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping("/test/{samplePathVariable}")
	public Map<String, Object> getSampleList(@PathVariable String samplePathVariable) {
		if ("right-path-value".equals(samplePathVariable)) {
			Map<String, Object> returnBody = new HashMap<>();
			returnBody.put("returnedListKey", sampleService.getSampleList());
			return returnBody;
		} else {
			return new HashMap<>();
		}
	}

}
