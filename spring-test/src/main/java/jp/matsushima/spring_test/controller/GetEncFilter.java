package jp.matsushima.spring_test.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class GetEncFilter
 * 2013/10/29
 */
//@WebFilter("/*")
public class GetEncFilter implements Filter {//extends org.springframework.web.filter.CharacterEncodingFilter {// implements Filter {

//	public static class MyHttpServletRequest extends HttpServletRequestWrapper {
//
//		public static String enc(String val) {
//			if (null == val) {
//				return null;
//			}
//			try {
//				return new String(val.getBytes("ISO_8859_1"), "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//		}
//
//		private Logger logger = Logger.getLogger(this.getClass());
//
//		@Override
//		public ServletInputStream getInputStream() throws IOException {
//			logger.debug("getInputStream");
//			return super.getInputStream();
//		}
//
//		@Override
//		public String getParameter(String arg0) {
//			logger.debug("getParameter:"+arg0);
//			//return enc(super.getParameter(arg0));
//			return super.getParameter(arg0);
//		}
//
//		@Override
//		public Map<String, String[]> getParameterMap() {
//			logger.debug("getParameterMap");
//			return super.getParameterMap();
//		}
//
//		@Override
//		public Enumeration<String> getParameterNames() {
//			logger.debug("getParameterNames");
//			return super.getParameterNames();
//		}
//
//		@Override
//		public String[] getParameterValues(String arg0) {
//			/*logger.debug("getParameterValues");
//			String[] values = super.getParameterValues(arg0);
//			String[] results = new String[values.length];
//			for (int i = 0; i < values.length; ++ i) {
//				results[i] = enc(values[i]);
//			}
//			return results;*/
//			return map.get(arg0);
//		}
//
//		@Override
//		public BufferedReader getReader() throws IOException {
//			logger.debug("getReader");
//			return super.getReader();
//		}
//
//		@Override
//		public String getQueryString() {
//			logger.debug("getQueryString");
//			return super.getQueryString();
//			/*String s = super.getQueryString();
//			try {
//				System.out.println(URLDecoder.decode(s, "UTF-8"));
//				s=URLDecoder.decode(s, "UTF-8");
//				s = new String(s.getBytes("ISO_8859_1"), "ISO_8859_1");
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			try {
////				s = new String(s.getBytes("ISO_8859_1"), "UTF-8");
//				s = URLEncoder.encode(s, "ISO_8859_1");
//				s = s.replace("%26", "&");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(s);
//			return s;*/
//		}
//
//		Map<String, String[]> map;
//		public MyHttpServletRequest(HttpServletRequest arg0) {
//			super(arg0);
//			map = new HashMap<String, String[]>(super.getParameterMap());
//			for (String[] values: map.values()) {
//				if (null != values) {
//					for (int v = 0; v < values.length; ++ v) {
//						values[v] = enc(values[v]);
//					}
//				}
//			}
//			logger.debug("HttpServletRequest");
//		}
////		private HttpServletRequest request;
////		public MyHttpServletRequest(HttpServletRequest request) {
////			this.request = request;
////		}
//		
//	}
//	
//    /**
//     * Default constructor. 
//     */
//    public GetEncFilter() {
//        // TODO Auto-generated constructor stub
//    }
	public static class MyHttpServletRequest extends HttpServletRequestWrapper {

		private Logger logger = Logger.getLogger(this.getClass());

		public static String enc(String val) {
			if (null == val) {
				return null;
			}
			try {
				return new String(val.getBytes("ISO_8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		Map<String, String[]> map;
		public MyHttpServletRequest(HttpServletRequest arg0) throws UnsupportedEncodingException {
			super(arg0);
			map = new HashMap<String, String[]>(super.getParameterMap());
			for (String[] values: map.values()) {
				if (null != values) {
					for (int v = 0; v < values.length; ++ v) {
						values[v] = enc(values[v]);
					}
				}
			}
			logger.debug("HttpServletRequest:"+arg0.getCharacterEncoding());
			setCharacterEncoding("UTF-8");
			org.springframework.web.filter.CharacterEncodingFilter f;
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			logger.debug("getParameterMap");
			//return super.getParameterMap();
			return map;
		}
		@Override
		public String[] getParameterValues(String arg0) {
			logger.debug("getParameterValues");
			return map.get(arg0);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request0, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
System.out.println("filter");
//((HttpServletRequest)request).setCharacterEncoding("UTF-8");

		// pass the request along the filter chain
//HttpServletRequest request = (HttpServletRequest) request0;
chain.doFilter(new MyHttpServletRequest((HttpServletRequest)request0), response);
//logger.debug(request.getServletPath());
// GET パラメータの文字化け回避
//request.setCharacterEncoding("UTF-8");
//chain.doFilter(request, response);
// サーブレットルートまでのパス
// http://localhost:8080/site/<context[/dir1/dir2/servlet]> -> [../."(./)../"] -> [../."(.)"] 
// http://localhost:8080/site/<context[/servlet]> -> ["()../"] -> ["(.)"] 
//request.setAttribute("contextPath", request.getServletPath().replaceAll("[^/]*/[^/]*", "../").replaceAll("(^|\\./)\\.\\./$", "."));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
