<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Query Executor</title>
</head>
<body>
    <h2>Запити для бд</h2>
    
    <!-- Форма для таблиці Music -->
    <h3>Geography</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="music">
        <textarea name="query" rows="4" cols="50" placeholder="Приклад: SELECT * FROM continent;"></textarea><br><br>
        <input type="submit" value="Виконати">
    </form>

    <!-- Вивід результатів -->
    <div id="Results">
        <h3>Результат::</h3>
        ${queryResult} <!-- Виведення результату виконання запиту -->
    </div>
</body>
</html>
