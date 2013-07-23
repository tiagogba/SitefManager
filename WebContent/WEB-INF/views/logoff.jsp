    <%@page contentType="text/html" pageEncoding="UTF-8"%>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
       "http://www.w3.org/TR/html4/loose.dtd">  
    <%  
       request.getSession().invalidate();  
       response.sendRedirect("login");  
    %>  
    <html>  
        <head>  
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
            <title></title>  
        </head>  
        <body>  
              
        </body>  
    </html>  