<%-- 
    Document   : popola
    Created on : 11-giu-2016, 20.26.26
    Author     : vicky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jsp per il popolamento dinamico della tabella degli oggetti -->

<json:array>
    <c:forEach var="o" items="${listaOggetti}">
        <json:object>
            <json:property name="nome" value="${o.getNome()}"/>
            <json:property name="url" value="${o.getUrl()}"/>
            <json:property name="numPezzi" value="${o.getNumPezzi()}"/>
            <json:property name="prezzo" value="${o.getPrezzo()}"/>
            <json:property name="descrizione" value="${o.getDescrizione()}"/>
            <json:property name="id" value="${o.getId()}"/>
        </json:object>
    </c:forEach>
</json:array>