<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
    <h1>Add New Customer</h1>
    <form id="addCustomerForm">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required /><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required /><br>
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" /><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" /><br>
        <label for="city">City:</label>
        <input type="text" id="city" name="city" /><br>
        <label for="state">State:</label>
        <input type="text" id="state" name="state" /><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required /><br>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" /><br>
        <button type="submit">Add Customer</button>
    </form>
    <script>
        document.getElementById('addCustomerForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const formData = new FormData(e.target);
            const customer = {};
            formData.forEach((value, key) => customer[key] = value);

            const response = await fetch('/api/customers', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(customer)
            });

            if (response.ok) {
                window.location.href = 'customerList.jsp';
            } else {
                alert('Failed to add customer!');
            }
        });
    </script>
</body>
</html>
