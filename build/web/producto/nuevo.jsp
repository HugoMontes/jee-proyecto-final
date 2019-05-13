<%-- 
    Document   : nuevo
    Created on : 12-05-2019, 09:33:52 PM
    Author     : MONTES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:base>
    <jsp:attribute name="title">
        Nuevo Producto
    </jsp:attribute>
    <jsp:body>
        <form action="ProductoController?action=guardar" method="POST" role="form">
            <input type="hidden" name="id" value="0"/>
            <div class="form-group">
                <label>Nombre del producto:</label>
                <input type="text" name="nombre" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Unidad de medida:</label>
                <input type="text" name="unidadMedida" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Precio:</label>
                <input type="text" name="precio" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Stock actual:</label>
                <input type="text" name="stockActual" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Stock minimo:</label>
                <input type="text" name="stockMinimo" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Fecha de vencimiento (dd/mm/aaaa):</label>
                <input type="text" name="fechaVencimiento" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Categoria></label>
                <select name="categoria" class="form-control">
                    <option value="1">GOLOSINAS</option>
                    <option value="2">EMBUTIDOS</option>
                    <option value="3">HIGIENE PERSONAL</option>
                    <option value="4">LACTEOS</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="ProductoController" class="btn btn-default">Cancelar</a>
        </form>
    </jsp:body>
</template:base> 

