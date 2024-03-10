<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		margin : auto;
		width: 95%;
		height: 500px;
		text-align: center;
	}
	.days{
		font-weight: bold;
	}
	h2{
		text-align: center;
	}
	.sun{
		color: red;
	}
	.sat{
		color: blue;
	}
	#option{
		display: flex;
		justify-content: center;
	}
	select{
		margin-left: 5px;
	}
	
</style>
</head>
<% 
int year = (int)request.getAttribute("year");
int month = (int)request.getAttribute("month");
int day = (int)request.getAttribute("day");
int lastDay = (int)request.getAttribute("lastDay");
int week = (int)request.getAttribute("week");

int startDay = 1;
int weekDay = week;
%>
<body>
<div class="calendar">
	<div class="title">
	    <form id="prevMonthForm" action="<%=request.getContextPath()%>/calendar.do" method="post">
	        <input type="hidden" name="year" value="<%=year %>">
	        <input type="hidden" name="pmonth" value="<%=month %>">
	    </form>
	    <h2>
	        <a href="#" onclick="document.getElementById('prevMonthForm').submit(); return false;" class="prev-month">&lt;&lt;&lt;</a>
		    <label>${year }년 ${month}월</label>
	        <a href="#" onclick="document.getElementById('nextMonthForm').submit(); return false;" class="next-month">&gt;&gt;&gt;</a>
	    </h2>
	    <form id="nextMonthForm" action="<%=request.getContextPath()%>/calendar.do" method="post">
	        <input type="hidden" name="year" value="<%=year %>">
	        <input type="hidden" name="month" value="<%=month %>">
	    </form>
	</div>
	<div id="option">
		<input type="number" value="<%=year%>">
		<select>
			<option>3월</option>
		</select>
		<select>
			<option>한국어</option>
		</select>
		<select>
			<option>대한민국 표준시</option>
		</select>
	</div>
	
	<table border="3px">
		<tr>
			<td class="days">일</td>
			<td class="days">월</td>
			<td class="days">화</td>
			<td class="days">수</td>
			<td class="days">목</td>
			<td class="days">금</td>
			<td class="days">토</td>
		</tr>
		<tbody>
		    <tr>
		        <% 
		        for(int i = 1; i <= lastDay; i++) {
		            if (i == 1) {
		                for (int j = 1; j < weekDay; j++) {
		        %>
		                    <td></td>
		        <% 
		                }
		            }
		        %>
		            <% 
		            if (weekDay == 1) {
		            %>
		                <td class="sun"><%=startDay++%></td>
		            <% 
		            } else if (weekDay == 7) {
		            %>
		                <td class="sat"><%=startDay++%></td>
		            <% 
		            } else {
		            %>
		                <td><%=startDay++%></td>
		            <% 
		            }
		            %>
		        <%
		            if (weekDay == 7) {
		        %>
		                </tr><tr>
		        <%
		                weekDay = 1;
		            } else {
		                weekDay++;
		            }
		        }
		        
		        while (weekDay <= 7) {
		        %>
		            <td></td>
		        <%
		            weekDay++;
		        }
		        %>
		    </tr>
		</tbody>
	</table>
</div>

</body>
</html>