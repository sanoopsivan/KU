<!-- 
        NAME:       header.html
        DATE:       March 12, 2016
        AUTHOR:     Ananthakrishnan Prakash
        PURPOSE:    Header file to be included in all pages.
 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">

<head>

    <meta charset = "utf-8">
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge">
    <meta name = "viewport" content = "width=device-width, initial-scale=1">
    <meta name = "description" content = "">
    <meta name = "author" content = "">

    <title>KU</title>

    <link href = "<c:url value="/resources/css/bootstrap.min.css" />"  rel = "stylesheet">
    <link href = "<c:url value="/resources/css/sb-admin.css" />" rel = "stylesheet">
    <link href = "<c:url value="/resources/css/plugins/morris.css" />" rel = "stylesheet">
    <link href = "<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel = "stylesheet" type = "text/css">
    <link href = "<c:url value="/resources/css/customStyles.css" />" rel = "stylesheet">
    <link href = "<c:url value="/resources/css/sticky-footer.css" />" rel = "stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src = "https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src = "https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body>
        
   <%@ include file="navigation.jsp" %><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->
