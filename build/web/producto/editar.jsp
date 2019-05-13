<%-- 
    Document   : editar
    Created on : 12-05-2019, 11:58:24 PM
    Author     : MONTES
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:base>
    <jsp:attribute name="title">
        Editar Producto
    </jsp:attribute>
    <jsp:body>
        <form action="ProductoController?action=guardar" method="POST" role="form">
            <input type="hidden" name="id" value="${producto.id}"/>
            <div class="form-group">
                <label>Nombre del producto:</label>
                <input type="text" name="nombre" value="${producto.nombre}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Unidad de medida:</label>
                <input type="text" name="unidadMedida" value="${producto.unidadMedida}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Precio:</label>
                <input type="text" name="precio" value="${producto.precio}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Stock actual:</label>
                <input type="text" name="stockActual" value="${producto.stockActual}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Stock minimo:</label>
                <input type="text" name="stockMinimo" value="${producto.stockMinimo}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Fecha de vencimiento (dd/mm/aaaa):</label>
                <fmt:formatDate value="${producto.fechaVencimiento}"  
                                type="date" 
                                pattern="dd/MM/yyyy"
                                var="formatFechaVenc" />
                <input type="text" name="fechaVencimiento" value="${formatFechaVenc}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Categoria></label>
                <select name="categoria" class="form-control">
                    <option value="1" ${producto.idCategoria == 1 ? 'selected' : ''}>GOLOSINAS</option>
                    <option value="2" ${producto.idCategoria == 2 ? 'selected' : ''}>EMBUTIDOS</option>
                    <option value="3" ${producto.idCategoria == 3 ? 'selected' : ''}>HIGIENE PERSONAL</option>
                    <option value="4" ${producto.idCategoria == 4 ? 'selected' : ''}>LACTEOS</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="ProductoController" class="btn btn-default">Cancelar</a>
        </form>
    </jsp:body>
</template:base> 


