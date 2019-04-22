<%  /*
 String Page = request.getParameter("page");
 String Controller = "cliente";
 String View = "index";
 if(Page != null){
     View = request.getParameter("op");
     Controller = Page + "Controller";
 }else{
     Controller = Controller + "Controller";
 }
 response.sendRedirect(Controller+"?op="+View);
        */
 String Op = "list";
 String Page = request.getParameter("page");
 if(Page != null){
     Op = request.getParameter("op");
 }else{
     Page = "cliente";
 }
 response.sendRedirect("app?page="+Page+"&op="+Op);
%>
