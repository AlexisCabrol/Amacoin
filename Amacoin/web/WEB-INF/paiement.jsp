<%-- 
    Document   : paiement
    Created on : 22 janv. 2018, 17:01:53
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div class="container">
    <div class="row"><%if( (Boolean) request.getAttribute("paiement") == true) { %>
        Le paiement c'est bien déroulé !
    <% } else { %>
    Echec du paiement. <% } %></div>
<!-- PayPal Logo --><table border="0" cellpadding="10" cellspacing="0" align="center"><tbody><tr><td align="center"></td></tr><tr><td align="center"><a href="https://www.paypal.com/fr/webapps/mpp/paypal-popup" title="PayPal Comment Ca Marche" onclick="javascript:window.open('https://www.paypal.com/fr/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;"><img src="https://www.paypalobjects.com/webstatic/mktg/logo-center/logo_paypal_moyens_paiement_fr.jpg" border="0" alt="PayPal Acceptance Mark" /></a></td></tr></tbody></table><!-- PayPal Logo -->
<img src="assets/image/psc.jpg"/><img src="assets/image/skrill.png"/>
</div>
<jsp:include page="footer.jsp" />

