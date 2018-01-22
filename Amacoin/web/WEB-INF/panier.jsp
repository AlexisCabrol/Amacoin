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
        <div class="section"></div>
        <div class="container">
        <h3>Panier - récapitulatif des achats</h3>
        <% if((Boolean) session.getAttribute("panier") == false) { %>
        Votre panier est vide (ou n'existe pas).
               <% } else { %>
                    
                    <ul class="collection">
                        <li class="collection-item avatar">
                            <img src="assets/image/bitcoin.png" class="circle"/>
                                <span class="title">Bitcoin</span>
                                <p>Commande pour un total de : ${totalBTC}€</p>
                                   
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/ripple.png"/>
                               <span class="title">Ripple</span>
                               <p>Commande pour un total de : ${totalXRP}€</p>
                               
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/ethereum.png"/>
                                <span class="title">Ethereum</span>
                                <p>Commande pour un total de : ${totalETH}€</p>
                                 
                        </li>
                        <li class="collection-item avatar">
                            <img class="circle" src="assets/image/litecoin.png"/>
                                <span class="title">Litecoin</span>
                                <p>Commande pour un total de : ${totalLTC}€</p>
      
                        </li>
                    </ul>
                                <p>La commande à un total de : ${total}€</p>
                                <form action="panier" method="post">                             
  <button class="btn waves-effect waves-light light-blue accent-2" type="submit" name="btn">Envoyer la commande et procéder au paiement
    <i class="material-icons right">send</i>
  </button>
                                </form>
            
          <% } %>
        </div>
        <div class="section"></div>
    </body>
</html>
<jsp:include page="footer.jsp" />
