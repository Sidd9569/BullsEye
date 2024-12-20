// Sample data of predefined users (emails or phone numbers with passwords)
const users = [
    { username: 'user1@example.com', password: 'password123' },
    { username: 'user2@example.com', password: 'password456' },
    { username: '1234567890', password: 'password789' }, // Example phone number
  ];
  
  // Function to validate the login credentials
  function validateLogin() {
    // Get the input values
    const username = document.getElementById('form2Example11').value;
    const password = document.getElementById('form2Example22').value;
  
    // Check if the user exists and the password is correct
    const user = users.find(user => user.username === username && user.password === password);
  
    // If user is found and credentials match
    if (user) {
      // Redirect to the home page
      window.location.href = 'index.html'; // Change this to your home page URL
    } else {
      // Show error message if login fails
      alert('Invalid username or password. Please try again.');
    }
  }
  
  // Attach the validateLogin function to the login button
  document.querySelector('.btn-primary').addEventListener('click', validateLogin);
  
