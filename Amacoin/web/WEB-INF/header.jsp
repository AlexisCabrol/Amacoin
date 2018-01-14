<%-- 
    Document   : header
    Created on : 21 déc. 2017, 08:11:32
    Author     : Alexis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amacoin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="asset/css/moncss.css" />
    </head>
    <body>
        
        
    <nav class="nav-extended light-blue accent-2">
        <div class="nav-background">
            <div class="pattern active" ></div>
        </div>
        <div class="nav-wrapper container">
            <a href="/" itemprop="url" class="brand-logo site-logo">
                Amacoin
            </a>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    <ul class="right hide-on-med-and-down">
          <li class="site-nav--active active">
            <a href="home" class="site-nav__link">Accueil</a>
          </li>

          <li class="site-nav--has-submenu">
            <a href="#"
               class="site-nav__link dropdown-button"
               data-activates="features-dropdown"
               data-belowOrigin="true"
               data-constrainWidth="false"
               data-hover="true">
              Crypto
              <i class="material-icons right">arrow_drop_down</i>
            </a>
            <ul id="features-dropdown" class="site-nav__submenu dropdown-content">
              
                <li >
                  <a href="bitcoin" class="site-nav__link">Bitcoin (BTC)</a>
                </li>
              
                <li >
                  <a href="ripple" class="site-nav__link">Ripple (XRP)</a>
                </li>
              
                <li >
                  <a href="ethereum" class="site-nav__link">Ethereum (ETH)</a>
                </li>
              
                <li >
                  <a href="litecoin" class="site-nav__link">Litecoin (LTC)</a>
                </li>
              
              
            </ul>
          </li>
          <%if(session.getAttribute("log") != null && ((Boolean) session.getAttribute("log") == true)) { %>
      <li>
        <a href="panier">
          <i class="material-icons left">shopping_cart</i>
          Panier  
        </a>
      </li> <% } %>
      
        
          <li>
            <% if(session.getAttribute("log") != null && ((Boolean) session.getAttribute("log") == true)) { %>
            <a href="account" id="account_link">Mon compte</a>
            <% } else { %>
            <a href="login" id="customer_login_link">S'identifier</a>
            <% } %>
            
          </li>
          <li>
              <% if(session.getAttribute("log") != null && ((Boolean) session.getAttribute("log") == true)) { %>
              <a href="login" id="customer_register_link">Déconnexion</a>
              <% } else { %>
              <a href="register" id="customer_register_link">Inscription</a>
              <% } %>
            
          </li>
        
      

    </ul>
  </div>
  
  <div class="nav-header center">
  

      <h1>Amacoin</h1>
      <div class="tagline">Online Cryptomoney shop</div>
    

  </div>
</nav>
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="assets/js/materialize.min.js"></script>
    </body>
</html>
