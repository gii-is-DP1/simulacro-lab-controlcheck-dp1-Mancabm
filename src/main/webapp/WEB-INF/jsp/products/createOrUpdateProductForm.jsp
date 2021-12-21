<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">
    <jsp:body>
        <h2>
            <c:if test="$product['new']">New</c:if> Product
        </h2>
        <form:form modelAttribute="pet"
        class="form-horizontal">
            <input type="hidden" name="id" value="${product.id}">
            <petclinic:inputField label="name" name="name"/>
            <petclinic:inputField label="price" name="price"/>
            <div class="control-group">
                <petclinic:selectField name="productType" label="productType" names="${producttypes}" size="5"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${product['new']}">
                            <button class="btn btn-default" type="submit">Add Product</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update Product</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <c:if test="${!pet['new']}">
        </c:if>
    </jsp:body> 
</petclinic:layout>