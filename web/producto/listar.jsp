<%-- 
    Document   : listar
    Created on : 12-05-2019, 08:18:43 PM
    Author     : MONTES
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:base>
    <jsp:attribute name="title">
        Productos
    </jsp:attribute>
    <jsp:body>
        <a href="ProductoController?action=nuevo" class="btn btn-success">Nuevo Producto</a>
        <table class="table">
            <tr>
                <th>ID</th>                
                <th>PRODUCTO</th>
                <th>UNIDAD MEDIDA</th>
                <th>PRECIO</th>
                <th>FECHA VENC.</th>
                <th>ACCION</th>
            </tr>
            <c:forEach var="prod" items="${productos}">
                <tr>
                    <td>${prod.id}</td>                    
                    <td>${prod.nombre}</td>
                    <td>${prod.unidadMedida}</td>
                    <td>${prod.precio}</td>
                    <td>${prod.fechaVencimiento}</td>
                    <td>
                        <a href="ProductoController?action=eliminar&id=${prod.id}">
                            Eliminar
                        </a>
                        <a href="ProductoController?action=editar&id=${prod.id}">
                            Editar
                        </a>
                    </td>
                </tr>    
            </c:forEach>
        </table>
    </jsp:body>
</template:base> 
