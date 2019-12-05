package cn.liuy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘洋
 * @aim 
 * SpringBoot整合controller层
*/

@Controller
public class SimpleController {

	@RequestMapping("/HiHi")
	@ResponseBody
	public Map<String, Object> showData()
	{
		Map<String, Object> app = new HashMap<String, Object>();
		app.put("liuy", "谦和滴洋洋");
		return app;
	}
}
