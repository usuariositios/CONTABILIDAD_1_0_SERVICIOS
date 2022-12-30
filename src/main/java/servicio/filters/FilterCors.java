package servicio.filters;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author henry
 */
public class FilterCors implements Filter {
    /**
   * Default constructor.
   */
  public FilterCors() {
    // TODO Auto-generated constructor stub
  }
 
  /**
   * @see Filter#destroy()
   */
  @Override
  public void destroy() {
    // TODO Auto-generated method stub
  }
 
  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  //@Override
  public void doFilter1(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
 
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    System.out.println("CORSFilter HTTP Request: " + request.getMethod());
 
    // Authorize (allow) all domains to consume the content
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
 
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
 
    // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
    if (request.getMethod().equals("OPTIONS")) {
      resp.setStatus(HttpServletResponse.SC_ACCEPTED);
      return;
    }
 
    // pass the request along the filter chain
    chain.doFilter(request, servletResponse);
  }
  
  @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                          FilterChain chain)throws ServletException, IOException{

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String referer = request.getHeader("referer");
        System.out.println("entro filtro * " + referer);
        
        //if(referer!=null && referer.length()>1){

            /*if(referer.endsWith("/")){
                referer = referer.substring(0, referer.length()-1);
            }*/
            //response.addHeader("Access-Control-Allow-Origin", referer);
            response.addHeader("Access-Control-Allow-Origin", "*");//el referer llega nulo en android
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,Access-Control-Allow-Methods,Access-Control-Allow-Origin");
            response.addHeader("Access-Control-Max-Age", "86400");//24 hours
        //}
        
        chain.doFilter(request, response);
    }
 
  /**
   * @see Filter#init(FilterConfig)
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }
}
