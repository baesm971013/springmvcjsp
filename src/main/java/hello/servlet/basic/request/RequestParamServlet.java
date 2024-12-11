package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 parameter 조회");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + request.getParameter(paramName)));

        System.out.println();
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String age = request.getParameter("age");
        System.out.println("age = " + age);

        System.out.println();
        System.out.println("복수 parameter");

        String [] usernames = request.getParameterValues("username");
        for (String s : usernames) {
            System.out.println(s);
        }

        response.getWriter().write("ok");

    }
}
