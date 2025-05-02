<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form id="loginForm">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required /><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br>
        <button type="submit">Login</button>
    </form>
    <script>
        document.getElementById('loginForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            const response = await fetch('/api/authenticate', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password })
            });

            if (response.ok) {
                const result = await response.json();
                localStorage.setItem('token', result.token); // Store token in local storage
                window.location.href = 'customerList.jsp';
            } else {
                alert('Login failed!');
            }
        });
    </script>
</body>
</html>
