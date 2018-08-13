package reuseLib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse {
	public int responseCode;
	public Map<String, List<String>> header;
	public HashMap<String,Object> body;
}
