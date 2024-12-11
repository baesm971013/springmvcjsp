package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);

    }

    private static void printStartLine(HttpServletRequest request) {
        String method = request.getMethod();
        String protocol = request.getProtocol();

        System.out.println("request.getScheme() = " + request.getScheme()); //http
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println("protocol = " + protocol);
        System.out.println("method = " + method);
    }

    private static void printHeader(HttpServletRequest request){
        System.out.println("Header---------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s);
        }
    }

}
