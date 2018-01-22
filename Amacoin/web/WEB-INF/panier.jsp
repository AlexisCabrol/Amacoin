<%-- 
    Document   : panier
    Created on : 12 janv. 2018, 10:15:42
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
        <h3>Panier</h3>
        <% if((Boolean) session.getAttribute("panier") == false) { %>
        Votre panier est vide (ou n'existe pas).
               <% } else { %>
                    
                    <ul class="collection">
                        <li class="collection-item avatar">
                            <img src="assets/image/bitcoin.png" class="circle"/>
                                <span class="title">Bitcoin</span>
                                   
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/ripple.png"/>
                               <span class="title">Ripple</span>
                               
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/ethereum.png"/>
                                <span class="title">Ethereum</span>
                                 
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/litecoin.png"/>
                                <span class="title">Litecoin</span>
      
                        </li>
                    </ul>
            
          <% } %>
        </div>
       
    </body>
</html>
<jsp:include page="footer.jsp" />
