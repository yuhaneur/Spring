<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .modal {
       display: none; 
       position: fixed;
       z-index: 1;
       left: 0;
       top: 0;
       width: 100%;
       height: 100%;
       overflow: auto;
       background-color: rgba(0,0,0,0.4);
   }
   .modal-content {
       background-color: #fefefe;
       margin: 15% auto;
       padding: 20px;
       border: 1px solid #888;
       width: 80%;
   }
   .close {
       color: #aaaaaa;
       float: right;
       font-size: 28px;
       font-weight: bold;
   }
   .close:hover,
   .close:focus {
       color: #000;
       text-decoration: none;
       cursor: pointer;
   }
    </style>
</head>
<body>
<%List<String[]> peopleList =(List<String[]>)request.getAttribute("memberList"); %>
	<ul>
		<%for(String[] member : peopleList){
		%>
    	<li id="<%=member[0]%>" onclick="showModal('<%=member[0]%>')"><%=member[1]%></li>
		<%
		}
		%>
    </ul>
    
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <table id="userInfo">
            </table>
        </div>
    </div>
    
<script>
	contextPath = '<%=request.getContextPath()%>'
	function showModal(id) {
		console.log("ddd")
		fetch(contextPath+"/people.do?who="+id)
	    .then(response => response.text())
	    .then(data => {
	    	console.log(data)
	        var modal = document.getElementById("myModal");
	        modal.style.display = "block";
	
	        var userInfo = document.getElementById("userInfo");
	        userInfo.innerHTML = data
	    });
	}
	function closeModal() {
	    var modal = document.getElementById("myModal");
	    modal.style.display = "none";
	}
</script>
</body>
</html>