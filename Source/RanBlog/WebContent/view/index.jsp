<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RanRan博客</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="RanRan的博客主页">
    <meta name="keys" content="RanRanm,博客,主页,小工具">
    <meta name="author" content="范华燃">
    <link rel="icon" href="favicon.ico" type="image/x-icon" /> 
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles this site-->
    <link  href="css/site.css" rel="stylesheet" />
 </head>
 <body>
    <%@ include file="common/header.jsp" %>
   
    <!-- Begin page content -->
    <div class="container">
      <div class="row">
        <div class="col-sm-6" style="margin:o auto;">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">注意事项</h3>
            </div>
            <div class="panel-body">
                <ul>
                  <li>原始图片必须为gif,jpg,jpeg,bmp,png格式</li>
                  <li>原始图片文件大小需要小于30M</li>
                  <li>原始图片长宽最好相等</li>
                  <li>选择文件上传后即可在线生成</li>
                </ul>
            </div>
          </div>
        </div>
        
        <div class="col-sm-6">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">说明</h3>
            </div>
            <div class="panel-body">
                <div class="well">
		        <p>ICOWebSite是一个开源免费的在线ico转换工具，支持gif,jpg,jpeg,bmp,png多种格式，可以同时上传多个图片文件，选择文件上传后即可在线生成，源码地址：https://github.com/FanHuaRan/ICOWebSite</p>
		      </div>
            </div>
          </div>
        </div>
      </div>
    </div> 

   <%@ include file="common/footer.jsp" %>

    <!-- Bootstrap core JavaScript
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>