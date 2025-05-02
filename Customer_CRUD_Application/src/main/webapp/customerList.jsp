<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <script>
        async function syncCustomers() {
            const authResponse = await fetch('https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ login_id: 'test@sunbasedata.com', password: 'Test@123' })
            });
            const authData = await authResponse.json();
            const token = authData.token;

            try {
                const response = await fetch('https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list', {
                    method: 'GET',
                    headers: { 'Authorization': `Bearer ${token}` }
                });

                if (!response.ok) {
                    throw new Error('Error fetching remote customers');
                }
                const remoteCustomers = await response.json();

                // Sync with local database
                await fetch('/api/sync', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(remoteCustomers)
                });

                fetchCustomers(); // Refresh customer list
            } catch (error) {
                console.error('Error syncing customers:', error);
            }
        }

        // Add other functions here...

        window.onload = fetchCustomers;
    </script>
</head>
<body>
    <h1>Customer List</h1>
    <button onclick="syncCustomers()">Sync</button>
    <a href="addCustomer.jsp">Add New Customer</a>
    <div id="customerList"></div>
</body>
</html>
