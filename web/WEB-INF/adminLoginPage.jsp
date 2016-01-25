<%-- 
    Document   : portailAdmin
    Created on : 10 janv. 2016, 10:59:35
    Author     : ChaySi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>IDGAF Administration Application</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>

    <!-- Header -->

    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                                <div class="intro-message">
                                     <form method="post" action="<c:url value="/ConnexionAdminServlet"/>">

                                         <fieldset>
                                                <legend>Fill required values</legend>
                                                <p class="alert-danger">${error}</p>
                                                <label for="userName">Username <span>*</span></label>
                                                <input type="text" id="v" name="login" size="30" maxlength="30"/>
                         
                                                <br />

                                                <label for="password">Password <span>*</span></label>
                                                <input type="password" id="v" name="password" size="30" maxlength="30"/>
                                               
                                                <br />
                                                <input align="right" type="submit" value="Login"  />
                                                <input align="left" type="reset" value="Reset" />

                                          </fieldset>


                                    </form>
                                    <h2>WELCOME TO IDGAF Administration APPLICATION</h2>
                                    <h3>Master intership's world...</h3>
                                    <hr class="intro-divider">
                                </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Page Content -->

</form>
<h2>loginAdministrator(String login, String password)</h2>
		<p>${admin}</p>
</body>

</html>
